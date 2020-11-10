package com.sweetmay.testapp.model.db

import androidx.room.*
import com.sweetmay.testapp.model.retrofit.Employee
import com.sweetmay.testapp.model.retrofit.Specialty

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employees")
    fun getAll(): List<EmployeeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employees : EmployeeEntity)

    @Query("DELETE FROM employees")
    fun nukeTable()
}