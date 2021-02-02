package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        // http://mellowcode.org/json/students/
        // base도메인을 지정
        // converter 주입
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)


        //Get Request
        /*service.getStudentsList().enqueue(object : Callback<ArrayList<NetworkPerson>> {
            override fun onFailure(call: Call<ArrayList<NetworkPerson>>, t: Throwable) {
                Log.d("retrofit","Error")
            }

            override fun onResponse(
                call: Call<ArrayList<NetworkPerson>>,
                response: Response<ArrayList<NetworkPerson>>
            ) {
                if(response.isSuccessful) {
                    //isSuccessful은  200번대 일 경우 true가 된다. (200, 204, .. 등등)
                    //response.body() 로 InputReader부터 필요한 부분을 모두 넣어서 List로 리턴시켜준다.
                    val personList = response.body()
                    Log.d("retrofit","Success")

                    val code = response.code()
                    Log.d("retrofit code : ", code.toString())

                    val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofit header", header.toString())

                }
            }
        })*/

        //Post Request
        /*val params = HashMap<String, Any>()
        params.put("name", "앱 개발")
        params.put("age", 9999)
        params.put("intro", "실화?")
        service.createStudent(params).enqueue(object: Callback<NetworkPerson>{
            override fun onFailure(call: Call<NetworkPerson>, t: Throwable) {
                Log.d("fail", "fail")
            }

            override fun onResponse(call: Call<NetworkPerson>, response: Response<NetworkPerson>) {
                if(response.isSuccessful) {
                    val person = response.body()
                    Log.d("result : ", person.toString())
                }
            }
        })*/

        //Post Request2
        service.createStudentEasy(NetworkPerson(name="앱 개발이냐구", age=99999, intro = "실화?ㅠ")).enqueue(object  : Callback<NetworkPerson>{
            override fun onFailure(call: Call<NetworkPerson>, t: Throwable) {
                Log.d("fail", "fail")
            }

            override fun onResponse(call: Call<NetworkPerson>, response: Response<NetworkPerson>) {
                if(response.isSuccessful) {
                    val person = response.body()
                    Log.d("result : ", person!!.name.toString())
                }
            }
        })

    }
}