package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class PieChartTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart_test)

        // 0. gradle로 라이브러리 삽입 후, layout에 view 를 생성해놓는다.

        // 1. Layout 에서 PieChart View 객체를 찾는다.
        val pieChar = findViewById<PieChart>(R.id.piechar)

        // 2. 그래프에 사용할 Color List 를 생성한다.
        var colors = mutableListOf<Int>()
        colors.add(Color.GRAY)
        colors.add(Color.BLUE)


        // 3. data1() 에서 그래프에 보여줄 데이터를 생성해서 받는다.
        val data = data1()

        // 4. PieChart에 넣어줄 dataset을 생성한다.
        val pieDataSet = PieDataSet(data,"충전량")

        // 5. dataset에 컬러를 주입.
        pieDataSet.colors = colors

        // 6. pieData 객체 생성.
        val pieData = PieData(pieDataSet)

        // 7. PueChart View 객체에 pieData 삽입.
        pieChar.data = pieData

        // 그래프에서 label 숨김
        pieChar.setDrawEntryLabels(false)

        // 그래프에 퍼센트 표시
        pieChar.setUsePercentValues(true)
        // 그래프 퍼센트 폰트 사이즈
        pieData.setValueTextSize(20f)

        // 그래프 중심에 그래프명 삽입
        pieChar.centerText = "충전량"
        pieChar.setCenterTextSize(40f)


       // end. 화면에 표시
        pieChar.invalidate()
    }

    private fun data1():List<PieEntry> {
        val list = ArrayList<PieEntry>()
        list.add(PieEntry(30f,"충전안됨"))
        list.add(PieEntry(70f,"충전됨"))
        return list
    }
}