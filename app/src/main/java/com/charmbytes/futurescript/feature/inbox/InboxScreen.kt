package com.charmbytes.futurescript.feature.inbox
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class CapsuleUi(val id: Long, val title: String?, val deliverAtFormatted: String, val locked: Boolean)
@Composable
fun InboxScreen(onCompose: () -> Unit, onOpen: (Long) -> Unit) {
    var items by remember {
        mutableStateOf(
            listOf(
                CapsuleUi(1, "Letter to Future Me", "2026-01-01", locked = true),
                CapsuleUi(2, "You did it!", "2025-12-01", locked = false)
            )
        )
    }
    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = onCompose) { Text("+") } }
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Letters", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(8.dp))
            LazyColumn {
                items(items) { item ->
                    Card(onClick = { onOpen(item.id) }, modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(item.title ?: "Untitled", modifier = Modifier.weight(1f))
                            Text(if (item.locked) "Locked" else "Unlocked")
                        }
                    }
                }
            }
        }
    }
}
