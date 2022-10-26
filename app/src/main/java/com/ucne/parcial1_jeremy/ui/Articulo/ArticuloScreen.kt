package com.ucne.parcial1_jeremy.ui.Articulo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ArticuloScreen(

    onNavigateBack: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel()

    ) {

    var nameError by remember {
        mutableStateOf(false)
    }

    var ErrorText = if (nameError) "Error: Obligatorio" else " "
    var ErrorColor = if (nameError){
        MaterialTheme.colors.error
    }
    else{
        MaterialTheme.colors.surface.copy(ContentAlpha.medium)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row{
                        Text(text = "Registro de Articulos")
                        Spacer(Modifier.width(16.dp))
                    }
                }
            )

        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(viewModel.descripcion.length <=0 || viewModel.marca.length<=0
                    ||viewModel.existencia.length<=0 ||viewModel.existencia.startsWith("0"))
                {
                    nameError = viewModel.descripcion.isBlank()
                    nameError = viewModel.marca.isBlank()
                    nameError = viewModel.existencia.isBlank()
                }
                else{
                    viewModel.Save()
                    onNavigateBack()
                }

            }) {
                Icon(imageVector = Icons.Filled.Done, contentDescription = "Add")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion")},
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it})
            if(viewModel.descripcion.length <= 0)
            {
                Text(text = ErrorText,
                color= ErrorColor)

            }

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Marca")},
                value = viewModel.marca,
                onValueChange = {viewModel.marca = it})
            if(viewModel.marca.length <= 0)
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Precio")},
                value = viewModel.precio,
                onValueChange = {viewModel.precio = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            if(viewModel.precio.length <= 0 || viewModel.precio.startsWith("0"))
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }

            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Existencia")},
                value = viewModel.existencia,
                onValueChange = {viewModel.existencia = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            if(viewModel.existencia.length <= 0 || viewModel.existencia.startsWith("0"))
            {
                Text(text = ErrorText,
                    color= ErrorColor)

            }



        }
    }

}