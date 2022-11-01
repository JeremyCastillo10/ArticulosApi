package com.ucne.parcial1_jeremy.data.remote

import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface ArticuloApi{

    @GET("api/Articulos")
    suspend fun GetList(): List<Articulodto>

    @POST("api/Articulos")
    suspend fun InsertarArticuloAPI(@Body articulodto: Articulodto): Response<Articulodto>

    @GET("api/Articulos/{Id}")
    suspend fun GetArticulo(@Path("Id") Id: Int): Response<List<Articulodto>>

    @PUT("api/Articulos/{Id}")
    suspend fun UpdateArticulo(@Path("Id") Id: Int, @Body articuloResponseDTO: Articulodto): Response<List<Articulodto>>

    @DELETE("api/Articulos/{Id}")
    suspend fun EliminarArticuloAPI(@Path("Id") Id: Int): Response<List<Articulodto>>
}