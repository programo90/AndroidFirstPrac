package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.zip.Inflater

class RetrofitRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_recycler)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService2::class.java)

        service.getStudentsList().enqueue(object : Callback<ArrayList<NetworkPerson>>{
            override fun onFailure(call: Call<ArrayList<NetworkPerson>>, t: Throwable) {
                Log.d("fail","fail")
            }

            override fun onResponse(
                call: Call<ArrayList<NetworkPerson>>,
                response: Response<ArrayList<NetworkPerson>>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()
                    data ?: ArrayList<NetworkPerson>()

                    val adapter = RetrofitRecyclerViewAdapter(LayoutInflater.from(this@RetrofitRecyclerActivity), data!!)
                    findViewById<RecyclerView>(R.id.retrofit_recycle_box).adapter = adapter
                }
            }
        })


        // AsyncTask 사용
        /*val asyncTask = RetofitRecyclerNetworkTask(findViewById(R.id.retrofit_recycle_box), LayoutInflater.from(this@RetrofitRecyclerActivity))
        asyncTask.execute()*/

    }
}

class RetofitRecyclerNetworkTask(
    val recyclerView: RecyclerView
    ,val inflater: LayoutInflater
): AsyncTask<Any?, Any?, Any?>() {


    override fun doInBackground(vararg params: Any?): Any? {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService2::class.java)
        var data: ArrayList<NetworkPerson>? = null
        service.getStudentsList().enqueue(object : Callback<ArrayList<NetworkPerson>>{
            override fun onFailure(call: Call<ArrayList<NetworkPerson>>, t: Throwable) {
                Log.d("Connection fail : ", call.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<NetworkPerson>>,
                response: Response<ArrayList<NetworkPerson>>
            ) {
                if(response.isSuccessful) {
                    data = response.body()
                    data ?: ArrayList<NetworkPerson>()

                    val adapter = RetrofitRecyclerViewAdapter(inflater, data!!)
                    recyclerView.adapter = adapter

                }
            }
        })

        return null
    }
}

class RetrofitRecyclerViewAdapter(
    val inflater: LayoutInflater
    ,val studentsList: ArrayList<NetworkPerson>
): RecyclerView.Adapter<RetrofitRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view : View):RecyclerView.ViewHolder(view) {
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = view.findViewById(R.id.network_person_name)
            age = view.findViewById(R.id.network_person_age)
            intro = view.findViewById(R.id.network_person_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.networkpersonitem,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(studentsList.get(position).name)
        holder.age.setText(studentsList.get(position).age.toString())
        holder.intro.setText(studentsList.get(position).intro)
    }
}