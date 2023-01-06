package com.sabekur2017.androidtddexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sabekur2017.androidtddexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}