package com.example.projectapppembelajaran.api

import com.example.projectapppembelajaran.model.ResponModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("nama_lengkap") nama_lengkap: String,
        @Field("nim") nim: String,
        @Field("prodi") prodi: String,
//        @Field("jenis_kelamin") jenis_kelamin: String,
    ): Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") username: String,
        @Field("password") password: String,
    ): Call<ResponModel>

    @GET("character")
    fun getMorty () : Call<ResponModel>
}