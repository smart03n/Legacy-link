package com.legacylinkmvp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HostActivity : AppCompatActivity() {

    private lateinit var dormancyTimer: DormancyTimer
    private lateinit var timerSpinner: Spinner
    private lateinit var startButton: Button

    private val timerOptions = listOf(
        "30 Minutes",
        "1 Hour",
        "6 Hours",
        "24 Hours"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        dormancyTimer = DormancyTimer(this)

        timerSpinner = findViewById(R.id.timerSpinner)
        startButton = findViewById(R.id.startTimerButton)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            timerOptions
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        timerSpinner.adapter = adapter

        startButton.setOnClickListener {
            val selected = timerSpinner.selectedItem.toString()

            val minutes = when (selected) {
                "30 Minutes" -> 30
                "1 Hour" -> 60
                "6 Hours" -> 360
                "24 Hours" -> 1440
                else -> 30
            }

            dormancyTimer.setDormancyPeriod(minutes)
            dormancyTimer.startTimer()

            Toast.makeText(
                this,
                "Dormancy timer set for $selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
