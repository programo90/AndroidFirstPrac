package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MyTubeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tube_detail)

        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@MyTubeDetailActivity)
        val videoView = findViewById<VideoView>(R.id.mytube_video)
        videoView.setVideoPath(url)
        videoView.requestFocus()
        videoView.start()

        mediaController.show()


        // MediaController
        // 간단한 동영상 제어

        // Exoplayer
        // 더 많은 기능을 제공, drm 기능 포함

    }
}