package com.ucne.parcial1_jeremy.ui.Articulo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ucne.parcial1_jeremy.data.local.dao.ArticuloDao
import com.ucne.parcial1_jeremy.data.local.entity.Articulo
import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import com.ucne.parcial1_jeremy.repository.ApiArticulosRepository
import com.ucne.parcial1_jeremy.repository.ArticuloRepository
import com.ucne.parcial1_jeremy.ui.ArticuloList.ArticuloListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticuloViewModel @Inject constructor(
    val repository: ApiArticulosRepository
):ViewModel() {
    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var precio by mutableStateOf("")
    var existencia by mutableStateOf("")
    private val _uiState = MutableStateFlow(ArticuloListUiState())
    val uiState: StateFlow<ArticuloListUiState> = _uiState.asStateFlow()

    fun Save()
    {
        viewModelScope.launch {
            repository.PostApiArticulos(
                Articulodto(
                    ariticuloId = 0,
                    descripcion = descripcion,
                    marca = marca,
                    precio = precio.toDouble(),
                    existencia = existencia.toDouble()
                )
            )
        }
    }
    fun refresh()
    {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(articulo = repository.GetApiArticulos().sortedBy { it.ariticuloId })
            }
        }
    }


}