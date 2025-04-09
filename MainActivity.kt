package com.example.appinputnama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NameInputScreen()
                }
            }
        }
    }
}

@Composable
fun NameInputScreen() {
    var name by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Masukkan Nama Anda", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            submittedName = name
        }) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (submittedName.isNotEmpty()) {
            Text(text = "Halo, $submittedName!", style = MaterialTheme.typography.titleMedium)
        }
    }
}
