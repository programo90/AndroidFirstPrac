package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val coment = resources.getString(R.string.greeting)
        Log.d("coment",coment)

        val comnet2 = getString(R.string.greeting)
        Log.d("comnet2",comnet2)


        val col1 = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getColor(R.color.textViewCol)
        } else {
            resources.getColor(R.color.textViewCol)
        }

        findViewById<Button>(R.id.resourceBtn).setBackgroundColor(col1)



    }
}