package com.sweetmay.testapp

import android.app.Application
import androidx.room.Room
import com.jakewharton.threetenabp.AndroidThreeTen
import com.sweetmay.testapp.model.db.EmployeeDao
import com.sweetmay.testapp.model.db.EmployeesDataBase

class App: Application() {

    private lateinit var dao: EmployeeDao
    private val synchObj = Any()

    companion object{
        lateinit var instance : App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AndroidThreeTen.init(this)

        val employeesDataBase = Room.databaseBuilder(
            applicationContext,
            EmployeesDataBase::class.java,
            "employees")
            .build()
        dao = employeesDataBase.getEmployeeDao()
    }

    fun getEmployeeDB(): EmployeeDao {
        synchronized(synchObj){
            return dao
        }
    }
}