package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Response

class OutstarMyPostListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstar_my_post_list)

        val myPostRecyclerView = findViewById<RecyclerView>(R.id.outstar_recycleview)
        val glide:RequestManager = Glide.with(this@OutstarMyPostListActivity)
        val inflater: LayoutInflater = LayoutInflater.from(this@OutstarMyPostListActivity)

        createList(myPostRecyclerView, glide, inflater)



        // Navi
        findViewById<TextView>(R.id.outstar_list_all).setOnClickListener {
            startActivity(Intent(this, OutStargramPostListActivity::class.java))
        }

        /*findViewById<TextView>(R.id.outstar_list_my).setOnClickListener {
            startActivity(Intent(this, OutstarMyPostListActivity::class.java))
        }*/

        findViewById<TextView>(R.id.outstar_list_upload).setOnClickListener {
            startActivity(Intent(this, OutStargramUploadActivity::class.java))
        }

        findViewById<TextView>(R.id.outstar_list_info).setOnClickListener {
            startActivity(Intent(this, OutstargramUserInfo::class.java))
        }
    }

    fun createList(
        myPostListActivity: RecyclerView
        ,glide: RequestManager
        ,inflater: LayoutInflater
    ) {
        (application as MasterApplication).service.getUserPostList()
            .enqueue(object : retrofit2.Callback<ArrayList<OutStarPost>>{
                override fun onFailure(call: Call<ArrayList<OutStarPost>>, t: Throwable) {
                    Log.d("network error : ", "error")
                }

                override fun onResponse(
                    call: Call<ArrayList<OutStarPost>>,
                    response: Response<ArrayList<OutStarPost>>
                ) {
                    if(response.isSuccessful) {
                        val myPostList = response.body()
                        val adapter = OutstarMyPostAdapter(myPostList!!, inflater, glide)
                        myPostListActivity.adapter = adapter
                        myPostListActivity.layoutManager = LinearLayoutManager(this@OutstarMyPostListActivity)
                    }
                }
            })
    }
}

class OutstarMyPostAdapter(
    var postList: ArrayList<OutStarPost>
    ,var inflater: LayoutInflater
    ,var glide: RequestManager
): RecyclerView.Adapter<OutstarMyPostAdapter.ViewHolder>(){
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val postOwner: TextView
        val postContent: TextView
        val postImage: ImageView
        init {
            postOwner = itemView.findViewById(R.id.outstar_post_owner)
            postContent = itemView.findViewById(R.id.outstar_post_content)
            postImage = itemView.findViewById(R.id.outstar_post_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.outstargram_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        glide.load(postList.get(position).image).into(holder.postImage)
    }
}