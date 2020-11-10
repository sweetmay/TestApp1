package com.sweetmay.testapp.view.ui.fragments.adapters.callbacks

import com.sweetmay.testapp.model.retrofit.Employee

interface OnEmployeeClick {
    fun onClick(employee: Employee)
}