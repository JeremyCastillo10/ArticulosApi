package com.ucne.parcial1_jeremy.data.remote

import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticuloApi{
    @GET("api/Articulos")
    suspend fun getApiArticulos(): Response < List<Articulodto>>

    @POST("api/Articulos")
    suspend fun postApiArticulos(@Body articulodto: Articulodto): Response < List<Articulodto>>

    @DELETE("api/Articulos/{Id}")
    suspend fun delApiArticulos(@Path("Id") Id: Int): Response < List<Articulodto>>
}