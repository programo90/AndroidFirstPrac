package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_activity)



        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread is made")
            }
        }

        val thread: Thread = Thread(runnable)
        thread.start()

        Thread(Runnable {
            Thread.sleep(1000)
            Log.d("thread2","thread2 made")
            runOnUiThread {
                findViewById<Button>(R.id.threadBtn).setBackgroundColor(getColor(R.color.textViewCol))
            }
        }).start()




    }
}