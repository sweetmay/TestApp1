package com.sweetmay.testapp.view.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sweetmay.testapp.R
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.view.ui.fragments.adapters.EmployeeAdapter
import com.sweetmay.testapp.view.ui.fragments.adapters.callbacks.OnEmployeeClick
import kotlinx.android.synthetic.main.employees_fragment.*

class EmployeesFragment() : BaseFragment(), OnEmployeeClick {

    lateinit var adapterRV: EmployeeAdapter

    override val layoutRes: Int?
        get() = R.layout.employees_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterRV = EmployeeAdapter(R.layout.item_employees, this)
        employees_rv.layoutManager = LinearLayoutManager(context)
        employees_rv.adapter = adapterRV
        viewModel.employeesData.value?.let { adapterRV.data = it }
    }

    override fun onClick(employee: Employee) {
        viewModel.chooseEmployee(employee)
    }
}