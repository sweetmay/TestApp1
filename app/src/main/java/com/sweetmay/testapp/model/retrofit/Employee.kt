package com.sweetmay.testapp.model.retrofit


data class Employee constructor(
        var avatr_url: String?,
        var birthday: String?,
        var f_name: String,
        var l_name: String,
        val specialty: List<Specialty>
){
    fun specialtiesToString() : String{
        return specialty.joinToString()
    }
}