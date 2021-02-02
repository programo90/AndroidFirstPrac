package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)
        val chAct:Button = findViewById(R.id.change_activity)
        chAct.setOnClickListener {
            val inten = Intent(this@Intent1, Intent2::class.java)
            inten.putExtra("num1",1)
            inten.putExtra("num2",2)

            inten.apply {
                inten.putExtra("num3",3)
                inten.putExtra("num4",4)
            }

            //startActivity(inten)
            startActivityForResult(intent,200)
        }

        val chAct2:Button = findViewById(R.id.change_activity2)
        chAct2.setOnClickListener {
            val inten = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(inten)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200) {
            Log.d("recode",""+requestCode)
            Log.d("resultCode",""+resultCode)
            val result = data?.getIntExtra("result",0)
        }
    }
}