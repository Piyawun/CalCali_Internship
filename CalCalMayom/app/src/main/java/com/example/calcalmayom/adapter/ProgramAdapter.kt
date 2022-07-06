package com.example.calcalmayom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calcalmayom.CalcalFragment
import com.example.calcalmayom.Model.ProgramModel
import com.example.calcalmayom.R

class ProgramAdapter (val programs: Context, private val activity: FragmentActivity) : RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {
    var programList = emptyList<ProgramModel>()


    internal fun setDataList(programList: List<ProgramModel>){
        this.programList = programList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ImageViewProgram: ImageView
        var textViewTitle: TextView
        var textViewLocation: TextView
        var textViewRate: TextView
        var textViewPrice: TextView

        init {
            ImageViewProgram = itemView.findViewById(R.id.ImageViewProgram)
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewLocation = itemView.findViewById(R.id.textViewLocation)
            textViewRate = itemView.findViewById(R.id.textViewRate)
            textViewPrice = itemView.findViewById(R.id.textViewPrice)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_program, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = programList[position]

        holder.ImageViewProgram.setImageResource(data.ImageViewProgram)
        holder.textViewTitle.text = data.textViewTitle
        holder.textViewLocation.text = data.textViewLocation
        holder.textViewRate.text = data.textViewRate
        holder.textViewPrice.text = data.textViewPrice

        holder.ImageViewProgram.setOnClickListener {
            val manager: FragmentManager = activity.supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.add(com.example.calcalmayom.R.id.rec, CalcalFragment(), "")
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount() = programList.size

}