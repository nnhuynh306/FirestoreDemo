package com.example.firestoreproject

import android.content.ContentProvider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.example.firestoreproject.app.YoutubeApp
import com.example.firestoreproject.app.rememberAppState
import com.example.firestoreproject.core.design.compositionlocals.LocalPaddings
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes
import com.example.firestoreproject.core.design.compositionlocals.Paddings
import com.example.firestoreproject.core.design.compositionlocals.Sizes
import com.example.firestoreproject.core.design.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CompositionLocalProvider(
                LocalPaddings provides Paddings(),
                LocalSizes provides Sizes(),
            ) {
                val appState = rememberAppState()

                AppTheme(
                    darkTheme = true
                ) {
                    YoutubeApp(appState)
                }
            }
        }
    }
}