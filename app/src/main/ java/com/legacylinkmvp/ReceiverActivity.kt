package com.legacylinkmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class ReceiverActivity : AppCompatActivity() {

    private lateinit var usbTransfer: UsbTransferManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        usbTransfer = UsbTransferManager(this)

        val connectButton: Button = findViewById(R.id.connectButton)
        connectButton.setOnClickListener {
            usbTransfer.connectToHost()
            Toast.makeText(this, "Attempting to connect to Host...", Toast.LENGTH_SHORT).show()
        }
    }
}
