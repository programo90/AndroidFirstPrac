package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment1:Fragment() {
    interface  OnDataPassListener{
        fun onDataPass(data: String?)
    }

    lateinit var dataPassListener: OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("life_cycle","F onAttach aaa")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onCreateView aaa")
        //fragment가 interface를 처음으로 그릴 때 호출
        //inflator 뷰를 그리는 역할
        // container fragment를 붙일 부모 뷰

        return inflater.inflate(R.layout.fragment1, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onViewCreated aaa")
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.fragSubBtn).setOnClickListener {
            dataPassListener.onDataPass("Good bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle","F onActivityCreated aaa")
        val data = arguments?.getString("hello")

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle","F onStart aaa")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle","F onResume aaa")
        super.onResume()
    }

    override fun onStop() {
        Log.d("life_cycle","F onStop aaa")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle","F onDestroyView aaa")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle","F onDetach")
        super.onDetach()
    }
}