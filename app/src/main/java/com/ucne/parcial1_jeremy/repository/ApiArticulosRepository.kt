package com.ucne.parcial1_jeremy.repository

import com.ucne.parcial1_jeremy.data.remote.ArticuloApi
import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ApiArticulosRepository @Inject constructor(
    val artapi: ArticuloApi
)
{
    suspend fun GetApiArticulos() = artapi.GetList()

    suspend fun PostApiArticulos(response: Articulodto) = artapi.InsertarArticuloAPI(response)



    suspend fun DeleteApiArticulos(Id: Int) = artapi.EliminarArticuloAPI(Id)





}
