package com.example.moscowmetro.model

import com.example.moscowmetro.MetroRepository

// ВРЕМЯ ОЖИДАНИЕ ПОЕЗДА (В МИНУТАХ)
const val AverageWaitTime = 2
// ВРЕМЯ ДО СЛЕДУЮЩЕЙ СТАНЦИИ
const val AverageWayTime = 2.5

data class Route(
    val startStation: Station,       // Откуда выехали
    val endStation: Station,         // Куда приехали
    val path: MutableList<Station>,
    val totalTimeMinutes: Double,
    val transfersCount: Int = 0
)

fun findRoute(startStation: Station, endStation: Station, allStation: List<Station>): Route {
    if (startStation.id == endStation.id) {
        return Route(startStation, endStation, mutableListOf(startStation), 0.0)
    }
    return when {
        startStation.line == endStation.line -> {
            val lineStation = allStation.filter { it.line == startStation.line }
            calculateSameLineRoute(startStation, endStation, lineStation)
        }
        else -> {
            // TODO: Добавить поддержку пересадок между линиями
            throw IllegalArgumentException("Маршруты между разными линиями пока не поддерживаются")
        }
    }
}

private fun calculateSameLineRoute(start: Station, end: Station, all: List<Station>): Route {
    if (start.line.isCircle == false) {
        val minId = minOf(start.id, end.id)
        val maxId = maxOf(start.id, end.id)
        val waypoints = all.filter { minId < it.id && it.id < maxId }
        val path = waypoints.toMutableList()
        path.add(0, start)
        path.add(end)
        val timeInRoad = (waypoints.count() * 2.5) + 2.5
        val totalTime = timeInRoad + AverageWaitTime
        return Route(start, end, path, totalTime)
    } else return calculateCircleLine(start, end, all)
}


private fun calculateCircleLine(start: Station, end: Station, all: List<Station>): Route {
    val forwardDistance = ((end.order - start.order) + all.count()) % all.count() // по часовой
    val backwardDistance = ((start.order - end.order) + all.count()) % all.count() //  проив часовой
    val isForward = forwardDistance < backwardDistance

    val step = if (isForward) 1 else -1
    val total = all.size
    val path = mutableListOf<Station>()
    var currentIndex = all.indexOf (start)

    while (true) {
        val currentStation = all[currentIndex]
        path.add(currentStation)

        if (currentStation == end) break

        currentIndex = (currentIndex + step + total) % total
    }

    // 1. Считаем количество перегонов (интервалов между станциями)
    val travelSegmentsCount = path.size - 1

    // 2. Считаем чистое время движения
    val travelTime = travelSegmentsCount * AverageWayTime

    // 3. Итоговое время с учетом ожидания
    val totalTime = travelTime + AverageWaitTime

    return Route(start, end, path, totalTime)
}