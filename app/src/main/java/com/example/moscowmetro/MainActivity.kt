package com.example.moscowmetro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.moscowmetro.databinding.ActivityMainBinding
import com.example.moscowmetro.model.findRoute
import com.example.moscowmetro.MetroRepository
import com.example.moscowmetro.model.Route
import com.example.moscowmetro.model.RouteError
import com.example.moscowmetro.model.Station


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

            val startStation = MetroRepository.stationsList.find {
                it.name.equals(
                    startStationName,
                    ignoreCase = true
                )
            }
            val endStation = MetroRepository.stationsList.find {
                it.name.equals(
                    endStationName,
                    ignoreCase = true
                )
            }

            binding.etStartStation.error = null
            binding.etEndStation.error = null
            val error = validateStations(startStation, endStation, MetroRepository.stationsList)
            if (error == null) {
                val route = findRoute(startStation!!, endStation!!, MetroRepository.stationsList)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("time", route.totalTimeMinutes)
                intent.putExtra("stationCount", (route.path.size - 1))
                startActivity(intent)
            } else {
                showError(error)
            }

            binding.etStartStation.addTextChangedListener {
                binding.etStartStation.setBackgroundResource(R.drawable.bg_rounded)
                binding.etStartStation.hint = getString(R.string.hint_enter_text)
            }
            binding.etEndStation.addTextChangedListener {
                binding.etEndStation.setBackgroundResource(R.drawable.bg_rounded)
                binding.etEndStation.hint = getString(R.string.hint_enter_text)
            }
        }
    }

    private fun validateStations(start: Station?, end: Station?, list: List<Station>): RouteError? {
        return when {
            start == null -> RouteError.StationNotFound(true)
            end == null -> RouteError.StationNotFound(false)
            start == end -> RouteError.DoubledStation
            start.line != end.line -> RouteError.DifferentLines
            else -> null
        }
    }

    private fun showError(error: RouteError) {
        when (error) {
            is RouteError.StationNotFound -> if (error.isStartField) {
                binding.etStartStation.setBackgroundResource(R.drawable.bg_error)
                binding.etStartStation.setText("")
                binding.etStartStation.hint = getString(R.string.not_found_hint)
            } else {
                binding.etEndStation.setBackgroundResource(R.drawable.bg_error)
                binding.etEndStation.setText("")
                binding.etEndStation.hint = getString(R.string.not_found_hint)
            }

            is RouteError.DoubledStation -> {
                binding.etEndStation.setBackgroundResource(R.drawable.bg_error)
                binding.etEndStation.setText("")
                binding.etEndStation.hint = getString(R.string.doubled_station_hint)
            }

            is RouteError.DifferentLines -> {
                binding.etEndStation.setBackgroundResource(R.drawable.bg_error)
                binding.etEndStation.setText("")
                binding.etEndStation.hint = getString(R.string.different_lines_hint)
            }
        }
    }
}