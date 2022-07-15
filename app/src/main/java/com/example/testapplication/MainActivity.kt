package com.example.testapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testapplication.ui.theme.TestApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    LevelOne.ItemOne(text = "Hello $name!")
    LevelOne.LevelTwo.ItemTwo(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestApplicationTheme {
        Greeting("Android")
    }
}

sealed interface LevelOne {
    object ItemOne : LevelOne
    sealed interface LevelTwo : LevelOne {
        object ItemTwo : LevelTwo
    }

    @Composable operator fun invoke(text: String, modifier: Modifier = Modifier) = Text(text = text, modifier = modifier)
}