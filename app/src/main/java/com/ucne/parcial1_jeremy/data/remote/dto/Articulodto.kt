package com.ucne.parcial1_jeremy.data.remote.dto

data class Articulodto(
        val ariticuloId: Int,
        val descripcion: String,
        val marca: String,
        val precio: Double,
        val existencia: Double
)