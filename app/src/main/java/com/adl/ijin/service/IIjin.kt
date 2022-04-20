package com.adl.ijin.service

import com.adl.ijin.model.GetIjinResponse
import com.adl.ijin.model.ResponsePostData
import retrofit2.Call
import retrofit2.http.*


interface IIjin {

    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @GET("api/ijin/all")
    fun getAllIjin(): Call<GetIjinResponse>

    @FormUrlEncoded
    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @POST("api/ijin/add")
    fun addDataForm(@Field("kategori") kategori:String,@Field("dari") dari:String,
                     @Field("sampai") sampai:String,@Field("perihal") perihal:String,@Field("keterangan") keterangan:String):Call<ResponsePostData>

}