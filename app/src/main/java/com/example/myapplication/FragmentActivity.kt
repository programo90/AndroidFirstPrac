package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() , Fragment1.OnDataPassListener{


    override fun onDataPass(data: String?) {
        Log.d("pass",data.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val frag1 : Fragment1 = Fragment1()
        val bundle:Bundle = Bundle()
        bundle.putString("hello","hello")
        frag1.arguments = bundle

        //fragment를 동적으로 동작
        findViewById<Button>(R.id.fragBtn).setOnClickListener {
            val fragmentManager:FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragContainer, frag1)
            fragmentTransaction.commit()
        }


        findViewById<Button>(R.id.fragCABtn).setOnClickListener {
            val fragmentManager:FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            //detach(frag1) 으로 제거시 다시 붙이기가 안된다.
            //remove는 제거 후 다시 붙이기도 가능하다.
            fragmentTransaction.remove(frag1)
            fragmentTransaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart aaa")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume aaa")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }

}