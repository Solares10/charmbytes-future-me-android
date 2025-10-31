package com.charmbytes.futurescript.feature.compose
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun SendConfirmationScreen(onHome: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("Your letter is on the way! Go back to the home page to write more.")
        Spacer(Modifier.height(24.dp))
        Button(onClick = onHome, modifier = Modifier.fillMaxWidth()) { Text("HOME PAGE") }
    }
}
