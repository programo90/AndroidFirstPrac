package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

class OutStargramSignupActivity : AppCompatActivity() {

    lateinit var usernameView: EditText
    lateinit var userPassword1: EditText
    lateinit var userPassword2: EditText
    lateinit var registerBtn: Button
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if((application as MasterApplication).checkIsLogin()) {
            finish()
            startActivity(
              Intent(this,OutStargramPostListActivity::class.java)
            )
        } else {
            setContentView(R.layout.activity_out_stargram)
            initView(this@OutStargramSignupActivity)
            setupListener(this@OutStargramSignupActivity)
        }


    }

    fun initView(activity: Activity) {
        usernameView = activity.findViewById<EditText>(R.id.outstar_rogin_idbox)
        userPassword1 = activity.findViewById<EditText>(R.id.outstar_rogin_pwbox)
        userPassword2 = activity.findViewById<EditText>(R.id.outstar_rogin_pwcheckbox)
        registerBtn = activity.findViewById(R.id.outstar_signup_btn)
        loginBtn = activity.findViewById(R.id.outstar_login_btn)
    }

    fun setupListener(activity: Activity) {
        registerBtn.setOnClickListener {
            register(this@OutStargramSignupActivity)
        }
        loginBtn.setOnClickListener {
            startActivity(Intent(this@OutStargramSignupActivity, OutStargramLoginActivity::class.java))
        }
    }

    fun register(activity: Activity) {
        val username = getUserName()
        val password1 = getUserPassword()
        val password2 = getUserPasswordCheck()

        (application as MasterApplication).service.register(username, password1, password2)
            .enqueue(object :retrofit2.Callback<User>{
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(activity,"가입 실패",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful) {
                        Toast.makeText(activity,"가입 성공",Toast.LENGTH_LONG).show()
                        val user = response.body()
                        val token = user!!.token.toString()
                        saveUserToken(token, activity)

                        (application as MasterApplication).createRetrofit()

                        activity.startActivity(Intent(activity, OutStargramPostListActivity::class.java))

                    }
                }
            })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

    fun getUserName(): String {
        return usernameView.text.toString()
    }

    fun getUserPassword(): String {
        return userPassword1.text.toString()
    }

    fun getUserPasswordCheck(): String {
        return userPassword2.text.toString()
    }

}