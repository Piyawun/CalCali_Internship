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
import com.example.calcalmayom.Model.DataModel
import com.example.calcalmayom.R

class ContentAdapter (val contents: Context, private val activity: FragmentActivity) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImageContent: ImageView

        init {
            ImageContent = itemView.findViewById(R.id.ImageContent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]
        holder.ImageContent.setImageResource(data.ImageContent)
        holder.ImageContent.setOnClickListener {
            val manager: FragmentManager = activity.supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.add(com.example.calcalmayom.R.id.rec, CalcalFragment(), "")
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
    override fun getItemCount() = dataList.size
}