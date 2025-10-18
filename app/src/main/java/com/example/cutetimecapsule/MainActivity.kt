package com.example.cutetimecapsule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.cutetimecapsule.navigation.TimeCapsuleNavHost
import com.example.cutetimecapsule.ui.theme.CuteCapsuleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuteCapsuleTheme {
                Surface { TimeCapsuleNavHost() }
            }
        }
    }
}
