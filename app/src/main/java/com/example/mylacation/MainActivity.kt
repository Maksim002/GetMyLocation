package com.example.mylacation

import android.Manifest
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.findViewById<TextView>(R.id.dwdw).setOnClickListener {
            start()
        }

    }

    val requestPermissionLauncher = registerForActivityResult<String, Boolean>(
        ActivityResultContracts.RequestPermission()
    ) { result ->
        if (result) {
            println()
            // PERMISSION GRANTED
        } else {
            println()
            // PERMISSION NOT GRANTED
        }
    }
    // Ex. Launching ACCESS_FINE_LOCATION permission.
    fun start() {
        requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}