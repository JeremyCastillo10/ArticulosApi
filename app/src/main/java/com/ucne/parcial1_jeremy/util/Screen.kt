package com.ucne.parcial1_jeremy.util

sealed class Screen(val route: String){
    object ArticuloListScreen: Screen("ArticuloLista")
    object ArticuloScreen: Screen("Articulo")
}