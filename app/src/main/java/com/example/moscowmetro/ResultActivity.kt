package com.example.moscowmetro

import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import com.example.moscowmetro.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private var _binding: ActivityResultBinding? = null
    private val binding
        get() = _binding?: throw IllegalStateException("Binding for ActivityMainBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val time = intent.getIntExtra("time", 0)
        val stationCount = intent.getIntExtra("stationCount", 0)
        binding.tvResultTime.text = resources.getQuantityString(R.plurals.minutes, time, time)
        binding.tvStationCount.text = stationCount.toString()
    }
}