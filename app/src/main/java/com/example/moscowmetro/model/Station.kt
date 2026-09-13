package com.example.moscowmetro.model

data class Station(
    val id: Int,
    val name: String,
    val line: Line,
    val order: Int
)