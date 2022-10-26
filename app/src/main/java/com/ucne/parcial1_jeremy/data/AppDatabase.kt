package com.ucne.parcial1_jeremy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.parcial1_jeremy.data.local.dao.ArticuloDao
import com.ucne.parcial1_jeremy.data.local.entity.Articulo

@Database(
    entities = [Articulo::class],
    version = 3
)
abstract class AppDataBase : RoomDatabase(){

    abstract val ArticuloDao: ArticuloDao

}