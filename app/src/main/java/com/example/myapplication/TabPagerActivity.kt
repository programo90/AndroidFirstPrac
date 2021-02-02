package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager_activity)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText("one"))
        tabLayout.addTab(tabLayout.newTab().setText("two"))
        tabLayout.addTab(tabLayout.newTab().setText("three"))

        val pagerAdapter = PagerAdapter(supportFragmentManager, 3)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = pagerAdapter

        //tab을 클릭시 pager를 이동하도록 설정한다.
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
        })

        //page를 움직일때 tab의 선택부분도 변경되도록 설정한다.
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}

class PagerAdapter(fragmentManager: FragmentManager, val tabCount: Int): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Frag1()
            }
            1 -> {
                return Frag2()
            }
            2 -> {
                return Frag3()
            }
            else -> {
                return Frag1()
            }
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}

