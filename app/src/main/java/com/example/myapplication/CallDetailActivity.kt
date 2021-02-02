package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CallDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_detail)

        getInfoAndDraw()

        findViewById<ImageView>(R.id.call_detail_backBtn).setOnClickListener {
            onBackPressed()
        }
    }

    fun getInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")

        findViewById<TextView>(R.id.call_detail_username).setText(name)
        findViewById<TextView>(R.id.call_detail_phoneNum).setText(phone)

    }

}