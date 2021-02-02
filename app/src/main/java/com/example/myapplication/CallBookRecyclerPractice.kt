package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CallBookRecyclerPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_book_recycler_practice)

        val contactList = ArrayList<contact_prac>()
        for(i in 0 .. 29) {
            contactList.add(contact_prac("Hello","01012345678"))
        }

        val callBookAdapter = CallBookRecyclerViewAdapter(contactList = contactList, inflater = LayoutInflater.from(this@CallBookRecyclerPractice),activity = this)
        val recyclerView = findViewById<RecyclerView>(R.id.callBook_recyclebox)
        recyclerView.adapter = callBookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this@CallBookRecyclerPractice)
    }
}

class CallBookRecyclerViewAdapter(
        val contactList: ArrayList<contact_prac>
        ,val inflater: LayoutInflater
        ,val activity: Activity
): RecyclerView.Adapter<CallBookRecyclerViewAdapter.CallBookViewHolder>() {

    inner class CallBookViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView
        val ini: TextView
        val img: ImageView

        init {
            name = view.findViewById<TextView>(R.id.call_prac_name)
            ini = view.findViewById<TextView>(R.id.call_prac_ini)
            img = view.findViewById<ImageView>(R.id.call_prac_img)

            view.setOnClickListener {
                val intent = Intent(activity, CallDetailActivity::class.java)
                intent.putExtra("name", contactList.get(adapterPosition).name)
                intent.putExtra("phone", contactList.get(adapterPosition).phoneNum)
                activity.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallBookViewHolder {
        val view = inflater.inflate(R.layout.call_pracitce_block, null)
        return CallBookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: CallBookViewHolder, position: Int) {
        holder.name.setText(contactList.get(position).name)
        holder.ini.setText(contactList.get(position).name.substring(0,1))
        holder.img.setImageResource(R.drawable.call_user)
    }
}
