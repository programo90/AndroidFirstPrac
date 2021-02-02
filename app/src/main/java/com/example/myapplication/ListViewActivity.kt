package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()

        for(i in 0 .. 9) {
            carList.add(CarForList(""+i+"번째 car", ""+i+"번 engine"))
            Log.d("car name",carList.get(i).name)
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
        listView.setOnItemClickListener{ parent, view, position, id ->
            val car = adapter.getItem(position) as CarForList
            Toast.makeText(this@ListViewActivity, car.name + " " + car.engine, Toast.LENGTH_LONG).show()
        }

    }
}

class ListViewAdapter(val carList: ArrayList<CarForList>, val layoutInflater: LayoutInflater ): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /*val view = layoutInflater.inflate(R.layout.item_view, null)
        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

        carNameTextView.setText(carList.get(position).name)
        carEngineTextView.setText(carList.get(position).engine)

        return view*/

        val view : View
        val holder: ViewHolder

        if(convertView == null) {
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.carName?.setText(carList.get(position).name)
        holder.carEngine?.setText(carList.get(position).engine)

        return view


    }

    override fun getItem(position: Int): Any {
        return carList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return carList.size
    }
}

class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}
