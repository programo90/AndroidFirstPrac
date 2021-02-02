package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        Glide.with(this@LibraryActivity)
            .load("https://img.insight.co.kr/static/2020/07/23/700/rwf657213w13r81yqhze.jpg")
            .into(findViewById(R.id.glideImgBox))

    }
}