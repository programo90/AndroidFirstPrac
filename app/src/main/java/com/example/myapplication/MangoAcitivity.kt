package com.example.myapplication

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import java.net.URI

class MangoAcitivity : AppCompatActivity() {
    lateinit var glide: RequestManager
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mango_acitivity)

        findViewById<Button>(R.id.music_load_btn).setOnClickListener {
            (application as MasterApplication).service.getMusicList()
                .enqueue(object : retrofit2.Callback<ArrayList<Music>>{
                    override fun onFailure(call: Call<ArrayList<Music>>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<ArrayList<Music>>,
                        response: Response<ArrayList<Music>>
                    ) {
                        if(response.isSuccessful) {
                            glide = Glide.with(this@MangoAcitivity)
                            val musicList = response.body()
                            val adapter = MangoAdapter(musicList!!, LayoutInflater.from(this@MangoAcitivity), glide, this@MangoAcitivity)
                            val recyclerView = findViewById<RecyclerView>(R.id.mango_list_recyclerview)
                            recyclerView.adapter = adapter
                        }
                    }
                })
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    inner class MangoAdapter(
        var musicList: ArrayList<Music>
        ,val inflater: LayoutInflater
        ,val glide: RequestManager
        ,val activity : Activity
    ) : RecyclerView.Adapter<MangoAdapter.ViewHolder>(){
        inner  class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            val title: TextView
            val thumbnail: ImageView
            val playBtn: ImageView

            init {
                title = itemView.findViewById(R.id.music_title)
                thumbnail = itemView.findViewById(R.id.music_thumbnail)
                playBtn = itemView.findViewById(R.id.music_play_btn)

                playBtn.setOnClickListener {
                    val position = adapterPosition
                    val path = musicList.get(position).song

                    try{
                        mediaPlayer?.stop()
                        mediaPlayer?.release()
                        mediaPlayer = null
                        mediaPlayer = MediaPlayer.create(
                            this@MangoAcitivity
                            , Uri.parse(path)
                        )
                        mediaPlayer?.start()
                    } catch(e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.music_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return musicList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.setText(musicList.get(position).title)
            glide.load(musicList.get(position).thumbnail).into(holder.thumbnail)
        }
    }
}
