package com.example.calcalmayom

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calcalmayom.Model.BannerModel
import com.example.calcalmayom.Model.DataModel
import com.example.calcalmayom.Model.MenuModel
import com.example.calcalmayom.Model.ProgramModel
import com.example.calcalmayom.adapter.BannerAdapter
import com.example.calcalmayom.adapter.ContentAdapter
import com.example.calcalmayom.adapter.MenuAdapter
import com.example.calcalmayom.adapter.ProgramAdapter
import com.google.android.material.appbar.AppBarLayout

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var programAdapter: ProgramAdapter
    private lateinit var menuAdapter: MenuAdapter
    private var dataList = mutableListOf<DataModel>()
    private var bannerList = mutableListOf<BannerModel>()
    private var programList = mutableListOf<ProgramModel>()
    private var menuList = mutableListOf<MenuModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideActionBar()

        recyclerView = findViewById(R.id.recyclerViewBanner)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        bannerAdapter = BannerAdapter(applicationContext, this)
        recyclerView.adapter = bannerAdapter
        bannerList.add(BannerModel(R.drawable.slide))
        bannerList.add(BannerModel(R.drawable.slide_2))
        bannerAdapter.setDataList(bannerList)
        recyclerView.setOnClickListener {
        }

        recyclerView = findViewById(R.id.recyclerViewMenu)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,3)
        menuAdapter = MenuAdapter(applicationContext,this)
        recyclerView.adapter = menuAdapter
        menuList.add(MenuModel(R.drawable.ic_cal))
        menuList.add(MenuModel(R.drawable.ic_health))
        menuList.add(MenuModel(R.drawable.ic_event))
        menuAdapter.setDataList(menuList)
        recyclerView.setOnClickListener{
        }

        recyclerView = findViewById(R.id.recyclerViewContent)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        contentAdapter = ContentAdapter(applicationContext, this)
        recyclerView.adapter = contentAdapter
        dataList.add(DataModel(R.drawable.image_content))
        dataList.add(DataModel(R.drawable.image_content_2))
        dataList.add(DataModel(R.drawable.media))
        contentAdapter.setDataList(dataList)
        recyclerView.setOnClickListener{
        }

        recyclerView = findViewById(R.id.recyclerViewProgram)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        programAdapter = ProgramAdapter(applicationContext,this)
        recyclerView.adapter = programAdapter
        programList.add(ProgramModel("โปรแกรมตรวจสุขภาพ 20 รายการ","โรงพยาบาลพญาไท 2"
            ,"4.9 (200)","฿ 6,099",R.drawable.program1))
        programList.add(
            ProgramModel(
                "ตรวจสุขภาพประจำปีขั้นพื้นฐาน7 รายการ", "โรงพยาบาลบางประกอก 9", "5 (50)"
                ,"฿ 3,599", R.drawable.media))
        programList.add(ProgramModel("โปรแกรมตรวจสุขภาพ 20 รายการ","โรงพยาบาลพญาไท 2"
            ,"4.9 (200)","฿ 6,099",R.drawable.program1))
        programAdapter.setDataList(programList)
        recyclerView.setOnClickListener{
        }
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }
}