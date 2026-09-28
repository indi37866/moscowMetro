package com.example.moscowmetro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moscowmetro.databinding.ActivityMainBinding
import com.example.moscowmetro.model.findRoute
import com.example.moscowmetro.MetroRepository
import com.example.moscowmetro.model.Route


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityMainBinding must not be null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val startStationName = binding.etStartStation.text.toString().trim()
            val endStationName = binding.etEndStation.text.toString().trim()

            val startStation = MetroRepository.stationsList.find { it.name.equals(startStationName, ignoreCase = true) }
            val endStation = MetroRepository.stationsList.find { it.name.equals(endStationName, ignoreCase = true) }

            binding.etStartStation.error = null
            binding.etEndStation.error = null

            when {
                startStation == null -> binding.etStartStation.error = "Станция не найдена"
                endStation == null -> binding.etEndStation.error = "Станция не найдена"
                startStation == endStation -> binding.etEndStation.error = "Станции должны быть разными!"
                startStation.line != endStation.line -> {
                    binding.etEndStation.error = "Маршрут между ветками в разработке"
                    binding.etStartStation.error = "Маршрут между ветками в разработке"
                }
                else -> {
                    val route = findRoute(startStation, endStation, MetroRepository.stationsList)
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("time", route.totalTimeMinutes)
                    intent.putExtra("stationCount", (route.path.size - 1))
                    startActivity(intent)
                }
            }
        }
    }
}
