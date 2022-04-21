package com.adl.ijin.service

import com.adl.ijin.model.GetIjinResponse
import com.adl.ijin.model.ResponsePostData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ITracking {



    @FormUrlEncoded
    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @POST("api/tracking/add")
    fun addDataForm(@Field("id_user") id_user:String,@Field("latitude") latitude:String,
                     @Field("longitude") longitude:String,@Field("timestamp") timestamp:String):Call<ResponsePostData>




}