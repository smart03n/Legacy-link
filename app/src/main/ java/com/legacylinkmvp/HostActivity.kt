package com.legacylinkmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class HostActivity : AppCompatActivity() {

    private lateinit var dormancyTimer: DormancyTimer
    private lateinit var fileManager: FileSelectionManager
    private lateinit var usbTransfer: UsbTransferManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        dormancyTimer = DormancyTimer(this)
        fileManager = FileSelectionManager(this)
        usbTransfer = UsbTransferManager(this)

        val selectFilesButton: Button = findViewById(R.id.selectFilesButton)
        val startTimerButton: Button = findViewById(R.id.startTimerButton)

        selectFilesButton.setOnClickListener {
            fileManager.selectFiles()
        }

        startTimerButton.setOnClickListener {
            dormancyTimer.startTimer()
            Toast.makeText(this, "Dormancy timer started", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        usbTransfer.listenForReceiver(fileManager.getSelectedFiles(), dormancyTimer)
    }
}
