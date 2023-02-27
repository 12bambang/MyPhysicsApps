package com.example.myphysicsapps

import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {
    @GET("api/lessons/?populate=*")
    fun getMateri(): Call<MateriResponse>
}