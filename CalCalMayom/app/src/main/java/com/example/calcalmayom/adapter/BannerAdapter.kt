package com.example.calcalmayom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calcalmayom.CalcalFragment
import com.example.calcalmayom.Model.BannerModel
import com.example.calcalmayom.R


class BannerAdapter(val banners: Context, private val activity: FragmentActivity) : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    var bannerList = emptyList<BannerModel>()

    internal fun setDataList(bannerList: List<BannerModel>){
        this.bannerList = bannerList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImageBanner: ImageView

        init {
            ImageBanner = itemView.findViewById(R.id.ImageBanner)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_banner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = bannerList[position]
        holder.ImageBanner.setImageResource(data.ImageBanner)
        holder.ImageBanner.setOnClickListener {
            val manager: FragmentManager = activity.supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.add(com.example.calcalmayom.R.id.rec, CalcalFragment(), "")
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount() = bannerList.size

}