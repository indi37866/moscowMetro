package com.example.moscowmetro.model

import android.R.attr.data
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
    val transfersCount: Int
)

fun findRoute(startStation: Station, endStation: Station, allStation: List<Station>): Any {
    if (startStation.id == endStation.id) {
        return Route(startStation, endStation, mutableListOf(startStation), 0.0, 0)
    }
    return when {
        startStation.line == endStation.line -> {
            val lineStation = allStation.filter { it.line == startStation.line }
            calculateSameLineRoute(startStation, endStation, lineStation)
        }
        else -> {return 0}
    }
}


fun calculateSameLineRoute(start: Station, end: Station, all: List<Station>): Any {
    if (start.line.isCircle == false) {
        val minId = minOf(start.id, end.id)
        val maxId = maxOf(start.id, end.id)
        val waypoints = all.filter { minId < it.id && it.id < maxId }
        val path = waypoints.toMutableList()
        path.add(0, start)
        path.add(end)
        val timeInRoad = (waypoints.count() * 2.5) + 2.5
        val totalTime = timeInRoad + AverageWaitTime
        return println(Route(start, end, path, totalTime, path.count()))
    }
    return 0
}