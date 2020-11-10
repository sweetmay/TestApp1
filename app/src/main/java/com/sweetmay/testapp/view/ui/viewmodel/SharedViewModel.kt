package com.sweetmay.testapp.view.ui.viewmodel

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sweetmay.testapp.App
import com.sweetmay.testapp.model.db.EmployeeDao
import com.sweetmay.testapp.model.db.EmployeeEntity
import com.sweetmay.testapp.model.retrofit.Data
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.model.retrofit.GetData
import com.sweetmay.testapp.model.retrofit.Specialty
import com.sweetmay.testapp.utils.DateFormatter
import com.sweetmay.testapp.utils.formatName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class SharedViewModel() : ViewModel() {

    var data: List<Employee> = emptyList()
    var specialtyData = MutableLiveData<List<Specialty>>()
    var employeesData = MutableLiveData<List<Employee>>()
    var personData = MutableLiveData<Employee>()

    private val employeeDao: EmployeeDao by lazy {
        App.instance.getEmployeeDB()
    }

    fun requestData() {
        val dataProvider = GetData()
        dataProvider.fetch(object : Callback<Data>{
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                response.body()?.response?.let {
                    data = it
                    findSpecialties(it)
                    writeToDB(it)}
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })
    }

    private fun findSpecialties(list: List<Employee>) {
        val specialties = ArrayList<Specialty>()
        for (employee in list){
            for(specialty in employee.specialty){
                if(!specialties.contains(specialty)){
                    specialties.add(specialty)
                }
            }
        }
        specialtyData.value = specialties
    }

    private fun writeToDB(list: List<Employee>){
        thread {
            for (employee in list){
                val entity = EmployeeEntity(null, employee.avatr_url, DateFormatter.getFormattedDate(employee.birthday), formatName(employee.f_name), formatName(employee.l_name), employee.specialtiesToString())
                entity.replaceNulls()
                employeeDao.insert(entity)
            }
        }
}

    fun chooseSpecialty(specialtyToSearch: Specialty) {
        val employeesToShow = ArrayList<Employee>()
        for (employee in data){
            for (specialty in employee.specialty){
                if(specialty == specialtyToSearch){
                    employeesToShow.add(employee)
                    break
                }
            }
        }
        employeesData.value = employeesToShow
    }

    fun chooseEmployee(employee: Employee) {
        for (emp in data){
            if(employee==emp){
                personData.value = emp
            }
        }
    }
}