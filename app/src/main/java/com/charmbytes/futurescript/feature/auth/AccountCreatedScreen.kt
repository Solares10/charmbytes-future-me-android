package com.charmbytes.futurescript.feature.auth
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun AccountCreatedScreen(onLoginPage: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text("ACCOUNT CREATED!", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Thank you for signing up. Please login to start exploring Future Script.")
        Spacer(Modifier.height(24.dp))
        Button(onClick = onLoginPage, modifier = Modifier.fillMaxWidth()) { Text("LOGIN PAGE") }
    }
}
