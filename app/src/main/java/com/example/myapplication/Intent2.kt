package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val resultBtn:Button = findViewById(R.id.intenResultBtn)
        resultBtn.setOnClickListener {
            val num1 = intent.getIntExtra("num1",0)
            val num2 = intent.getIntExtra("num2",0)

            //Intent 생성
            val resultInten = Intent()

            //Paramter 대입
            resultInten.putExtra("result",num1+num2)

            //result 값 대입
            setResult(Activity.RESULT_OK)

            //현재 Activity 종료, Intent1 Activity는 종료되지 않았기 때문에 intent1 화면이 나온다.
            finish()
        }
    }
}