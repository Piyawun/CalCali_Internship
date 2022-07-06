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
import com.example.calcalmayom.Model.MenuModel
import com.example.calcalmayom.R

class MenuAdapter (val menu: Context, private val activity: FragmentActivity) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    var menuList = emptyList<MenuModel>()

    internal fun setDataList(menuList: List<MenuModel>){
        this.menuList = menuList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImageMenu: ImageView

        init {
            ImageMenu = itemView.findViewById(R.id.ImageMenu)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = menuList[position]

        holder.ImageMenu.setImageResource(data.ImageMenu)
        holder.ImageMenu.setOnClickListener {
            val manager: FragmentManager = activity.supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.add(com.example.calcalmayom.R.id.rec, CalcalFragment(), "")
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount() = menuList.size

}