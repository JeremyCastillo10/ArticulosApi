package com.ucne.parcial1_jeremy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucne.parcial1_jeremy.ui.Articulo.ArticuloScreen
import com.ucne.parcial1_jeremy.ui.ArticuloList.ArticuloListScreen
import com.ucne.parcial1_jeremy.ui.theme.Parcial1_JeremyTheme
import com.ucne.parcial1_jeremy.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_JeremyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.ArticuloListScreen.route)
                    {
                        composable(Screen.ArticuloListScreen.route){
                            ArticuloListScreen(
                                onClick = {navController.navigate(Screen.ArticuloScreen.route)}
                            )
                        }
                        composable(Screen.ArticuloScreen.route){
                            ArticuloScreen({navController.navigateUp()})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial1_JeremyTheme {
        Greeting("Android")
    }
}