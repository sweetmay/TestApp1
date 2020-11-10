package com.sweetmay.testapp.model.db

import androidx.room.*
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.model.retrofit.Specialty

@Entity(tableName = "employees", indices = [Index(value = ["f_name", "l_name", "birthday"],
        unique = true)])
data class EmployeeEntity(
        @PrimaryKey(autoGenerate = true)
        val employeeId : Long? = null,
        var avatr_url: String?,
        var birthday: String?,
        val f_name: String,
        val l_name: String,
        val specialty: String
){
    fun replaceNulls(){
        if(avatr_url.isNullOrBlank()){
            avatr_url = "-"
        }
        if(birthday.isNullOrBlank()){
            birthday = "-"
        }
    }
}
