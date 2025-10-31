package com.charmbytes.futurescript.feature.compose
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
@Composable
fun ComposeLetterScreen(onSent: () -> Unit, onBack: () -> Unit) {
    var text by remember { mutableStateOf("") }
    var date by remember { mutableStateOf<LocalDate?>(null) }
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        TextButton(onClick = onBack) { Text("BACK") }
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = text, onValueChange = { text = it },
            label = { Text("Write your letter here...") },
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
        Spacer(Modifier.height(12.dp))
        Text("Choose your send date:")
        TextButton(onClick = { date = LocalDate.now().plusDays(1) }) { Text(date?.toString() ?: "DD-MM-YYYY") }
        Spacer(Modifier.height(12.dp))
        Button(onClick = onSent, enabled = text.isNotBlank() && date != null, modifier = Modifier.fillMaxWidth()) {
            Text("SEND")
        }
    }
}
