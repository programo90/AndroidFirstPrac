package com.example.myapplication

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication : Application() {

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        createRetrofit()
    }


    // Retroifit을 생성해서 통신을 한다.
    // Login 상태를 체크해서 선택적으로 Retrofit을 생성한다.
    fun createRetrofit() {
        //본래 요청 을 Interceptor로 catch 한다.
        //original request에 header를 추가하고 it.proceed()로 다시 진행시킨다.
        val header = Interceptor {
            val original = it.request()

            if(checkIsLogin()) {
                getUserToken()?.let {token ->
                    val request = original.newBuilder()
                        .header("Authorization","token " +token)
                        .build()
                    it.proceed(request)
                }
            } else {
                it.proceed(original)
            }
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)

    }

    // 로그인 상태를 체크한다.
    // SharedPreference에 Token이 들어 있다면 로그인으로 간주한다.
    fun checkIsLogin(): Boolean {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        return token != "null"
    }

    fun getUserToken(): String? {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token =  sp.getString("login_sp", "null")
        return if(token == "null") null
        else token
    }

}