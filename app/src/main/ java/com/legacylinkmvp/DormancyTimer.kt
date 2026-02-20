package com.legacylinkmvp

import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast

class DormancyTimer(private val context: Context) {

    private var timer: CountDownTimer? = null
    private var dormancyPeriodMillis: Long = 24 * 60 * 60 * 1000 // default 24h

    fun setDormancyPeriod(hours: Int) {
        dormancyPeriodMillis = (hours * 60 * 60 * 1000).toLong()
    }

    fun startTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(dormancyPeriodMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                Toast.makeText(context, "Dormancy period expired. Files ready for transfer.", Toast.LENGTH_LONG).show()
            }
        }.start()
    }

    fun cancelTimer() {
        timer?.cancel()
    }

    fun isDormant(): Boolean {
        // For simplicity: returns true if timer finished
        return timer == null
    }
}
