package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        // Mode
        // MODE_PRIVATE : 생성한 application에서만 사용 가능하다.
        // MODE_WORLD_READABLE : 다른 app에선 읽기만 가능
        // MODE_WORLD_WRITABLE : 다른 app에서 읽기, 쓰기 모두 가능
        // MODE_MULTI_PROCESS : 이미 호출되 사용중인지 체크
        // MODE_APPEND : 기존 preference에 추가

        // editor를 이용해 sp에 data를 넣거나 조작한다.
        /*val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("hello", "Hello!")
        editor.commit()*/

        val spBtn = findViewById<Button>(R.id.sp_btn)
        spBtn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value = sharedPreference.getString("hello","no data")
            Log.d("key",value.toString())

        }

        findViewById<Button>(R.id.sp_save_btn).setOnClickListener {
            val sp = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("bye","Bye!")
            editor.commit()
        }

        findViewById<Button>(R.id.sp_load_btn).setOnClickListener {
            val sp = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            Log.d("value : ",sp.getString("bye","no data").toString())
        }

        findViewById<Button>(R.id.sp_delete_btn).setOnClickListener {
            val sp = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.remove("bye")
            editor.commit()
        }

        findViewById<Button>(R.id.sp_all_delete_btn).setOnClickListener {
            val sp = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.clear()
            editor.commit()
        }



        // Device에서 setting-app-my application(내가 만든 app이름) - app info
        // storage와 cashe를 삭제하면 sharedPreference도 모두 삭제된다.


    }
}