package com.example.moscowmetro

import com.example.moscowmetro.MetroRepository.yellowLineA
import com.example.moscowmetro.model.Station
import com.example.moscowmetro.model.findRoute
import org.junit.Test
import com.example.moscowmetro.MetroRepository.stationsList

class ExampleUnitTest {
    @Test
    fun test() {
        val firstStation = Station(14, "Аэропорт Внуково", yellowLineA, 14)
        val secondStation = Station(11, "Новопеределкино", yellowLineA, 11)
        findRoute(firstStation, secondStation, stationsList)
    }
}