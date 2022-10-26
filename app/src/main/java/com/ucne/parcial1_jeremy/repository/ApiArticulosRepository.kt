package com.ucne.parcial1_jeremy.repository

import com.ucne.parcial1_jeremy.data.remote.ArticuloApi
import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiArticulosRepository @Inject constructor(
    val artapi: ArticuloApi
)
{
    suspend fun GetApiArticulos():List<Articulodto>{
        try {
            return withContext(Dispatchers.IO)
            {
                val apiArticulo = artapi.getApiArticulos()
                apiArticulo.body()?: emptyList()
            }
        }catch (e: Exception){
            throw e
        }
    }

    suspend fun PostApiArticulos(articulodto: Articulodto):List<Articulodto>{
        try {
            return withContext(Dispatchers.IO)
            {
                val apiArticulo = artapi.postApiArticulos(articulodto)
                apiArticulo.body()?: emptyList()
            }
        }catch (e: Exception){
            throw e
        }
    }

    suspend fun DeleteApiArticulos(articulodto: Articulodto):List<Articulodto>{
        try {
            return withContext(Dispatchers.IO)
            {
                val apiArticulo = artapi.delApiArticulos(articulodto.ariticuloId)
                apiArticulo.body()?: emptyList()
            }
        }catch (e: Exception){
            throw e
        }
    }




}
