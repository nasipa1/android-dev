@file:Suppress("ComposePreviewMustBeTopLevelFunction")

package com.example.ura

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ura.ui.theme.UraTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var lastClicked by remember { mutableStateOf("Jmi davai") }
    var count1 by remember { mutableStateOf(0) }
    var count2 by remember { mutableStateOf(0) }
    var count3 by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "Posledni jmal: $lastClicked"
            , fontSize = 30.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Count 1: $count1",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .weight(6f)
                    .background(Color.Red)
                    .height(60.dp)

            )

            Button(onClick = {
                count1++
                lastClicked = "Priv"

            }) {
                Text("Priv",
                    fontSize = 25.sp)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, ) {
            Text(text = "Count 2: $count2",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .weight(6f)
                    .background(Color.Magenta)
                    .height(60.dp))




            Button(onClick = {
                count2++
                lastClicked = "Kak dela"
            }) {
                Text("Kak dela",
                    fontSize = 25.sp)
            }

        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Count 3: $count3",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .weight(6f)
                    .background(Color.Blue)
                    .height(60.dp))
            Button(onClick = {
                count3++
                lastClicked = "Pobeda"
            }) {
                Text("Pobeda",
                    fontSize = 25.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    UraTheme {
        Counter()
    }
}
