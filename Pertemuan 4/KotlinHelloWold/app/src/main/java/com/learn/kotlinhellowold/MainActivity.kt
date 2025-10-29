package com.learn.kotlinhellowold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.kotlinhellowold.ui.theme.KotlinHelloWoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinHelloWoldTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(WindowInsets.safeDrawing.asPaddingValues())) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf(false) }
    Column(modifier = modifier.padding()){
        Text(
            text = "Hello $name!",
            fontSize =  24.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = "Mas Jawir",
            fontSize = 18.sp,
            color = Color.Red,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (isClicked) "Woilah mas Jawir ngeklick loh ya" else "Klik dong mas Jawir",
            fontSize = 18.sp,
            color = if (isClicked) Color.Green else Color.Red,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { isClicked = !isClicked}) {
            Text(text = if (isClicked) "Balikkan" else "Ubah Text")
        }

    }
}
