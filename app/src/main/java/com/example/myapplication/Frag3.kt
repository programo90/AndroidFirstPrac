package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Frag3: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onCreateView aaa")
        //fragment가 interface를 처음으로 그릴 때 호출
        //inflator 뷰를 그리는 역할
        // container fragment를 붙일 부모 뷰

        return inflater.inflate(R.layout.fragment3, container,false)
    }
}