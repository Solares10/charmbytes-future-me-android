package com.charmbytes.futurescript.feature.detail
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun LetterDetailScreen(id: Long, onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        TextButton(onClick = onBack) { Text("BACK") }
        Spacer(Modifier.height(8.dp))
        Text("Letter #$id", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))
        Text("This is where the decrypted letter text will appear once unlocked.")
    }
}
