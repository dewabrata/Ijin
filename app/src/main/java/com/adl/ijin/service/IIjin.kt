package com.adl.ijin.service

import com.adl.ijin.model.GetIjinResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface IIjin {

    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @GET("api/ijin/all")
    fun getAllIjin(): Call<GetIjinResponse>
}