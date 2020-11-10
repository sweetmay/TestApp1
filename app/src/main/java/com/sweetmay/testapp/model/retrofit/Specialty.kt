package com.sweetmay.testapp.model.retrofit

data class Specialty(
        val name: String,
        val specialty_id: Int,
){
        override fun toString(): String {
                return name
        }
}
