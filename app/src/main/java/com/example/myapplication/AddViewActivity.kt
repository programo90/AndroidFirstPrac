package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val carList = ArrayList<CarForList>()
        for(i in 0 .. 9) {
            carList.add(CarForList(""+i+"번 째 car", ""+i+"번 째 engine"))
        }

        val container = findViewById<LinearLayout>(R.id.addview_container)
        val inflater = this@AddViewActivity.layoutInflater
        for(i in 0 until carList.size) {
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carList.get(i).name)
            carEngineView.setText(carList.get(i).engine)
            container.addView(itemView)
        }

    }

}

class CarForList(val name:String, val engine:String) {

}