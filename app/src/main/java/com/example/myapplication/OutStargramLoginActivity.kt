package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

class OutStargramLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.outstar_signup_btn).setOnClickListener {
            val intent = Intent(this, OutStargramSignupActivity::class.java )
            startActivity(intent)
        }

        findViewById<Button>(R.id.outstar_login_btn).setOnClickListener {
            val username = findViewById<EditText>(R.id.outstar_rogin_idbox).text.toString()
            val password = findViewById<EditText>(R.id.outstar_rogin_pwbox).text.toString()
            (application as MasterApplication).service.login(
                username, password
            ).enqueue(object: retrofit2.Callback<User>{
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("error","login fail")
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful) {
                        val user = response.body()
                        val token = user!!.token
                        saveUserToken(token.toString(), this@OutStargramLoginActivity)
                        (application as MasterApplication).createRetrofit()
                        Toast.makeText(this@OutStargramLoginActivity, "Login success", Toast.LENGTH_LONG).show()

                        startActivity(Intent(this@OutStargramLoginActivity, OutStargramPostListActivity::class.java))
                    }

                }
            })
        }
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }
}