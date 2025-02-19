package com.example.sqliteexample

import DatabaseHelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sqliteexample.ui.theme.SQLiteExampleTheme

class MainActivity : ComponentActivity() {
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the DatabaseHelper here
        databaseHelper = DatabaseHelper(this)

        setContent {
            SQLiteExampleTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    InputScreen(databaseHelper) // Call your Composable function here
                }
            }
        }
    }
}

@Composable
fun InputScreen(databaseHelper: DatabaseHelper) {
    // Your UI code here, including EditText and Button
}
