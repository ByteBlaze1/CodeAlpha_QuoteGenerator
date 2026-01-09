package com.example.codealpha_quotegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteApp()
        }
    }
}

@Composable
fun QuoteApp() {
    val quotes = listOf(
        "Believe in yourself." to "Author A",
        "Code is like humor. When you have to explain it, it’s bad." to "Cory House",
        "Stay hungry, stay foolish." to "Steve Jobs",
        "First, solve the problem. Then, write the code." to "John Johnson"
    )

    var currentQuote by remember { mutableStateOf(quotes[0]) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = currentQuote.first, fontSize = 24.sp, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "- ${currentQuote.second}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            currentQuote = quotes[Random.nextInt(quotes.size)]
        }) {
            Text("New Quote")
        }
    }
}