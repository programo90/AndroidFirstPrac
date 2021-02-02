package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OutstargramUserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstargram_user_info)

        findViewById<TextView>(R.id.outstar_list_all).setOnClickListener {
            startActivity(Intent(this, OutStargramPostListActivity::class.java))
        }

        findViewById<TextView>(R.id.outstar_list_my).setOnClickListener {
            startActivity(Intent(this, OutstarMyPostListActivity::class.java))
        }

        findViewById<TextView>(R.id.outstar_list_upload).setOnClickListener {
            startActivity(Intent(this, OutStargramUploadActivity::class.java))
        }

        /*findViewById<TextView>(R.id.outstar_list_info).setOnClickListener {
            startActivity(Intent(this, OutstargramUserInfo::class.java))
        }*/

        findViewById<TextView>(R.id.outstar_info_logout).setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp","null")
            editor.commit()
            (application as MasterApplication).createRetrofit()
            finish()
            startActivity(Intent(this, OutStargramLoginActivity::class.java))
        }
    }
}