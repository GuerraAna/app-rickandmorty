package com.example.app_rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewBinding()
        _binding.text.text = "Rick and Morty app"
    }

    private fun setupViewBinding() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
    }
}