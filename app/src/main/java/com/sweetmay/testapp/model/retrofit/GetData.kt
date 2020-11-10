package com.sweetmay.testapp.model.retrofit

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetData {

    companion object {
        private const val BASE_URL = "https://gitlab.65apps.com/"
    }

    private lateinit var apiCall: ApiCall

    fun fetch(retrofitCallback: Callback<Data>){
        initRetrofit()
        apiCall.load().enqueue(retrofitCallback)
    }

    private fun initRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiCall = retrofit.create(ApiCall::class.java)
    }

}