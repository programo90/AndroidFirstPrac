package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        val helloTextView: TextView = findViewById(R.id.hello)

        //lamda
        helloTextView.setOnClickListener {
            Log.d("click","Click!")
            helloTextView.setText("안녕하세요")
        }

        //Anonymous Class
        //kotlin에선 lamda 방식이 추천된다.
        /*textView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click","Click2")
            }
        })*/

        /*helloTextView.setText("안녕하세요")*/
        val gradiImgView: ImageView = findViewById(R.id.gradi)
        gradiImgView.setOnClickListener {
            gradiImgView.setImageResource(R.drawable.ttun)
        }
    }
}