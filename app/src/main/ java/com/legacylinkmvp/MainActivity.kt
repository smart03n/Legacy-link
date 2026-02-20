package com.legacylinkmvp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hostButton: Button = findViewById(R.id.hostButton)
        val receiverButton: Button = findViewById(R.id.receiverButton)

        hostButton.setOnClickListener {
            startActivity(Intent(this, HostActivity::class.java))
        }

        receiverButton.setOnClickListener {
            startActivity(Intent(this, ReceiverActivity::class.java))
        }
    }
}
