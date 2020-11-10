package com.sweetmay.testapp.view.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sweetmay.testapp.model.retrofit.Specialty
import com.sweetmay.testapp.view.ui.fragments.adapters.callbacks.OnSpecialtyClick
import kotlinx.android.synthetic.main.item_specialties.view.*


class SpecialtiesAdapter(private val itemRes: Int, private val onSpecialtyClick: OnSpecialtyClick) : RecyclerView.Adapter<SpecialtiesAdapter.ViewHolder>() {

    var data = listOf<Specialty>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(itemRes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onSpecialtyClick.onClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(specialty: Specialty){
            itemView.specialty_name.text = specialty.toString()
        }
    }
}