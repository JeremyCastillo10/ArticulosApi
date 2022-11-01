package com.ucne.parcial1_jeremy.ui.ArticuloList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ucne.parcial1_jeremy.data.local.entity.Articulo
import com.ucne.parcial1_jeremy.data.remote.dto.Articulodto


@Composable
fun ArticuloListScreen(
    onClick: () -> Unit,
    viewModel: ArticuloListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row{
                        Text(text = "Lista")
                        Spacer(Modifier.width(16.dp))
                        androidx.compose.material.Icon(
                            Icons.Filled.Refresh,
                            contentDescription = "refresh",
                            modifier = Modifier

                                .fillMaxSize()
                                .padding(start = 270.dp)
                                .clickable {
                                    viewModel.refresh()

                                }

                        )

                    }

                }

            )


        },

        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            ArticuloLista(
                articulo = uiState.articulo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

    }

}



@Composable
fun ArticuloLista(
    articulo: List<Articulodto>,
    modifier: Modifier = Modifier,
    viewModel: ArticuloListViewModel= hiltViewModel()
) {

    LazyColumn(modifier = modifier) {
        items(articulo) { anonima ->
            ArticuloRow(anonima,viewModel)
        }
    }
}

@Composable
fun ArticuloRow(articulo: Articulodto, viewModel: ArticuloListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        androidx.compose.material.Icon(
            Icons.Filled.Delete,
            contentDescription = "Fecha",
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    viewModel.Delete(articulo.ariticuloId)

                }

        )
        Text(text = "ArticuloId: ${articulo.ariticuloId}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )
        Text(text = "Descripcion: ${articulo.descripcion}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )
        Text(text = "Marca: ${articulo.marca}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )
        Text(text = "Precio: ${articulo.precio}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )
        Text(text = "Existencia: ${articulo.existencia}",
            style = TextStyle(fontFamily = FontFamily.Default),
            color = Color.White
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}



