package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Response

class MyTubeActivity : AppCompatActivity() {
    lateinit var glide : RequestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tube)

        (application as MasterApplication).service.getYoutubeList()
            .enqueue(object: retrofit2.Callback<ArrayList<Youtube>>{
                override fun onFailure(call: Call<ArrayList<Youtube>>, t: Throwable) {
                    Log.d("get list error : ","error")
                }

                override fun onResponse(
                    call: Call<ArrayList<Youtube>>,
                    response: Response<ArrayList<Youtube>>
                ) {
                    if(response.isSuccessful) {
                        glide = Glide.with(this@MyTubeActivity)
                        val mytubeList = response.body()
                        val adapter = MyTubeAdapter(mytubeList!!, LayoutInflater.from(this@MyTubeActivity),glide, this@MyTubeActivity)
                        val recyclerView = findViewById<RecyclerView>(R.id.mytube_list_recycler)
                        recyclerView.adapter = adapter

                    }
                }
            })
    }
}

class MyTubeAdapter(
    var mytubeList: ArrayList<Youtube>
    ,val inflater: LayoutInflater
    ,val glide: RequestManager
    ,val activity:Activity
): RecyclerView.Adapter<MyTubeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val content: TextView
        val thumbnail: ImageView

        init {
            title = itemView.findViewById(R.id.mytube_title)
            content = itemView.findViewById(R.id.mytube_content)
            thumbnail = itemView.findViewById(R.id.mytube_thumbnail)

            itemView.setOnClickListener {
                val position = adapterPosition
                val intent = Intent(activity, MyTubeDetailActivity::class.java)
                intent.putExtra("video_url",mytubeList.get(position).video)
                activity.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.youtube_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mytubeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(mytubeList.get(position).title)
        holder.content.setText(mytubeList.get(position).content)
        glide.load(mytubeList.get(position).thumbnail).into(holder.thumbnail)
    }
}