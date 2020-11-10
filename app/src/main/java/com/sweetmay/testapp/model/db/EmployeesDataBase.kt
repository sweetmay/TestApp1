package com.sweetmay.testapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sweetmay.testapp.model.retrofit.Employee

@Database(entities = [EmployeeEntity::class], version = 1)

abstract class EmployeesDataBase : RoomDatabase() {
    abstract fun getEmployeeDao() : EmployeeDao
}