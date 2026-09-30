package com.example.moscowmetro.model

sealed class RouteError {
    data class StationNotFound (val isStartField: Boolean): RouteError()
    object DoubledStation: RouteError()
    object DifferentLines: RouteError()
}