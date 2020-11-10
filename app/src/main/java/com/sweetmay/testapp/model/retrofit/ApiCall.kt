package com.sweetmay.testapp.model.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("65gb/static/raw/master/testTask.json")
    fun load(): Call<Data>
}