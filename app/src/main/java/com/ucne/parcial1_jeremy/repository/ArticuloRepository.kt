package com.ucne.parcial1_jeremy.repository

import androidx.room.Query
import com.ucne.parcial1_jeremy.data.AppDataBase
import com.ucne.parcial1_jeremy.data.local.entity.Articulo
import javax.inject.Inject

class ArticuloRepository @Inject constructor(
    val db: AppDataBase
) {
    suspend fun InsertarArticulo(articulo: Articulo){
        db.ArticuloDao.insertararticulo(articulo)
    }

    suspend fun UpdateArticulo(articulo: Articulo){
        db.ArticuloDao.updatearticulo(articulo)
    }
    suspend fun Buscar(articuloId: Int){
        db.ArticuloDao.find(articuloId)
    }
    fun GetList() = db.ArticuloDao.getList()
}