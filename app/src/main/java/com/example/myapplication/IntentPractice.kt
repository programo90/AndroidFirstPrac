package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.ActivityIntentPracticeBinding

class IntentPractice : AppCompatActivity() {
    private lateinit var binding:ActivityIntentPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_practice)

        val searchBtn:Button = findViewById(R.id.intent_prac_searchBtn)
        searchBtn.setOnClickListener {
            connectUri()
        }
        val editBox:EditText = findViewById(R.id.intent_prac_urlBox)
        editBox.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.d("edit","onTextChanged")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun connectUri() {
        val urlBox:EditText = findViewById(R.id.intent_prac_urlBox)
        val inten = Intent(Intent.ACTION_VIEW, Uri.parse("http://"+urlBox.text.toString()))
        startActivity(inten)
    }



}