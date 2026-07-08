package com.example.suma2numerosb

import android.R.attr.text
import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button


import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suma2numerosb.ui.theme.Suma2NumerosBTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Suma2NumerosBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Nuñes Juan ",
                        modifier = Modifier.padding(innerPadding)


                    )
                    SumadoraApp()

                }
            }
        }
    }
}
// esta notacion es para decirle al compilador que esta instruccion es una funcion contructora de interfaz
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Suma2NumerosBTheme {
        Greeting("Android")
    }
}

@Composable
fun SumadoraApp(){
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var numero3 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("0") }

    Column(modifier = Modifier.
    fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Text(
            text = "Ingresa el primer numero"
           // color = Color.Red
        )
        //cuadro de texto y etiqueta lebel para pedir  el perimer numero
        OutlinedTextField(value =  numero1, onValueChange = {numero1= it},
            label = {"Escribe el Numero 1"},
keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )
        )

        Spacer(modifier= Modifier.height(8.dp))
        Text(
            text = "ingresa el segundo Numero"

        )
        //cuadro de texto y etiqueta lebel para pedir  el segundo numero
        OutlinedTextField(value =  numero2, onValueChange = {numero2= it},
            label = {"Escribe el Numero 2"},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number )
        )

        Spacer(modifier= Modifier.height(16.dp))

        // boton con funcion

        Button(
            onClick = {
            val n1 =numero1.toDouble()?: 0.0
            val n2 =numero2.toDouble()?: 0.0

                resultado = (n1+n2).toString()
            },
            modifier = Modifier.fillMaxWidth()
            ){
            Text("Sumar Numeros")
        }
        Spacer(modifier= Modifier.height(16.dp))

        Text("el resultado de la suma es :$resultado")


    }}



