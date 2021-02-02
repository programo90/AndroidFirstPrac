package com.example.myapplication

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)


        NetworkTask(
            findViewById(R.id.recycler_person)
            ,LayoutInflater.from(this@NetworkActivity)
        ).execute()
    }
}

class NetworkTask(
    val recyclerView: RecyclerView
    ,val inflater: LayoutInflater
): AsyncTask<Any?, Any?,Array<NetworkPerson>>() {

    override fun onPostExecute(result: Array<NetworkPerson>) {
        //이 메서드 안에서 UI Thread에 접근이 가능하다.
        //result는 doInBackground() return을 받아준다.
        val adapter = NetworkPersonAdapter(result, inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<NetworkPerson> {
        val urlString:String = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        //GET, POST, DELETE, PUT
        connection.requestMethod="GET"
        connection.setRequestProperty("Content-type","application/json")

        var buffer = ""
        if(connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader =BufferedReader(InputStreamReader(connection.inputStream, "UTF-8"))
            buffer = reader.readLine()
            Log.d("conn",buffer.toString())
        }

        val data = Gson().fromJson(buffer, Array<NetworkPerson>::class.java)

        return data
    }
}


class NetworkPersonAdapter(
    val personList : Array<NetworkPerson>
    ,val inflater: LayoutInflater
): RecyclerView.Adapter<NetworkPersonAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.network_person_name)
            age = itemView.findViewById(R.id.network_person_age)
            intro = itemView.findViewById(R.id.network_person_intro)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.networkpersonitem,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name)
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro)
    }
}