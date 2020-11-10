package com.sweetmay.testapp.view.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweetmay.testapp.R
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.utils.DateFormatter
import com.sweetmay.testapp.utils.formatName
import com.sweetmay.testapp.view.ui.fragments.adapters.callbacks.OnEmployeeClick
import kotlinx.android.synthetic.main.item_employees.view.*

class EmployeeAdapter(private val itemRes: Int, private val onEmployeeClick: OnEmployeeClick) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    var data = listOf<Employee>()
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
            onEmployeeClick.onClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(employee: Employee) = with(itemView){
            Glide.with(this).load(employee.avatr_url).error(R.drawable.ic_launcher_foreground).into(
                picture
            )
            if(!employee.birthday.isNullOrEmpty()){
                val day = employee.birthday
                birthday.text = day?.let {
                    DateFormatter.getAgeByBirthday(it)
                }
            }else{
                birthday.text = "««"
            }
            val fullName = formatName(employee.f_name)+ " " + formatName(employee.l_name)
            name.text = fullName
        }
    }
}