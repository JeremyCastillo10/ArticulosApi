package com.ucne.parcial1_jeremy.ui.ArticuloList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.parcial1_jeremy.data.local.entity.Articulo
import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto
import com.ucne.parcial1_jeremy.repository.ApiArticulosRepository
import com.ucne.parcial1_jeremy.repository.ArticuloRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


data class ArticuloListUiState(
    val articulo: List<Articulodto> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class ArticuloListViewModel @Inject constructor(
    val repository: ApiArticulosRepository

) : ViewModel() {

    private val _uiState = MutableStateFlow(ArticuloListUiState())
    val uiState: StateFlow<ArticuloListUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(articulo = repository.GetApiArticulos().sortedBy { it.ariticuloId })
            }
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

    fun Delete(Id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.DeleteApiArticulos(Id)
            _uiState.update {
                it.copy(articulo = repository.GetApiArticulos().sortedBy { it.ariticuloId })
            }

        }

    }

}
