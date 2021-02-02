package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.RecyclerView

class CallPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_practice)

        val contactList = ArrayList<contact_prac>()
        for(i in 1 .. 30) {
            contactList.add(contact_prac("Hello","01012345678"))
        }

        val contactContainer = findViewById<LinearLayout>(R.id.call_prac_container)
        val inflater = this@CallPractice.layoutInflater

        for(i in 0 until contactList.size) {
            val user = contactList.get(i)
            val userBlock = inflater.inflate(R.layout.call_pracitce_block,null)
            userBlock.findViewById<TextView>(R.id.call_prac_ini).setText(user.name.substring(0,1).toUpperCase())
            userBlock.findViewById<ImageView>(R.id.call_prac_img).setImageResource(R.drawable.call_user)
            userBlock.findViewById<TextView>(R.id.call_prac_name).setText(user.name)
            userBlock.setOnClickListener {
                val intent = Intent(this@CallPractice, CallDetailActivity::class.java)
                intent.putExtra("name",user.name)
                intent.putExtra("phone",user.phoneNum)
                startActivity(intent)
            }
            contactContainer.addView(userBlock)
        }



    }

}

class contact_prac(val name:String, val phoneNum: String) {

}