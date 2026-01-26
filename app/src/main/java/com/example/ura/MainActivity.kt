@file:Suppress("ComposePreviewMustBeTopLevelFunction")

package com.example.ura

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ura.ui.theme.UraTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UraTheme {
                Carta()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        println("onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

}

@Composable
fun Carta() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9ACD32))
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(2f),
        ) {
            val image = painterResource(id = R.drawable.shrek)
            Image(
                painter = image,
                contentDescription = "Shrek",
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF4A5D23), CircleShape)
                    .background(Color(0xFFFEBE10))
                    .padding(8.dp)


            )
            Text(
                text = "Nasipa Abdyraiymova",
                fontSize = 30.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Ura Pobeda",
                color = Color(0xFF444C38),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

        val contacts = listOf(
            "+996 996-996-996" to Icons.Filled.Phone,
            "@privetpupsik" to Icons.Filled.Share,
            "privpriv@ura.com" to Icons.Filled.Email
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            items(contacts) { (text, icon) ->
                ContactInfoRow(icon = icon, text = text)
            }
        }
        Box(
            modifier = Modifier
                .weight(0.5f)
        )

    }

}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF444C38),
            modifier = Modifier.padding(end = 24.dp)
        )
        Text(text = text, fontSize = 16.sp)
    }
}

//    var lastClicked by remember { mutableStateOf("Ne jmal") }
//    var count1 by remember { mutableStateOf(0) }
//    var count2 by remember { mutableStateOf(0) }
//    var count3 by remember { mutableStateOf(0) }
//


//    Column(
//        modifier = modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//
//    ) {
//        Text(text = "Posledni jmal: $lastClicked"
//            , fontSize = 32.sp,
//            color = if (lastClicked == "Ne jmal")
//                Color.Black
//            else Color.White,
//
//            modifier = Modifier
//                .padding(16.dp)
//                .background(color = if (lastClicked == "Ne jmal")
//                    Color.White
//                else if (lastClicked == "Pobeda")
//                    Color.Blue
//
//                else if (lastClicked == "Priv")
//                    Color.Red
//                else if (lastClicked == "Kak dela")
//                    Color.Magenta
//                else Color.White
//                )
//        )
//
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text(text = "Count 1: $count1",
//                fontSize = 40.sp,
//                color = Color.White,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .align(Alignment.CenterVertically)
//                    .weight(4f)
//                    .background(Color.Red)
//                    .height(60.dp)
//
//            )
//
//            Button(onClick = {
//                count1++
//                lastClicked = "Priv"
//
//            }) {
//                Text("Priv",
//                    fontSize = 25.sp)
//            }
//        }
//
//        Row(verticalAlignment = Alignment.CenterVertically, ) {
//            Text(text = "Count 2: $count2",
//                fontSize = 40.sp,
//                color = Color.White,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .align(Alignment.CenterVertically)
//                    .weight(4f)
//                    .background(Color.Magenta)
//                    .height(60.dp))
//
//
//
//
//            Button(onClick = {
//                count2++
//                lastClicked = "Kak dela"
//            }) {
//                Text("Kak dela",
//                    fontSize = 25.sp)
//            }
//
//        }
//
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text(text = "Count 3: $count3",
//                fontSize = 40.sp,
//                color = Color.White,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .align(Alignment.CenterVertically)
//                    .weight(4f)
//                    .background(Color.Blue)
//                    .height(60.dp))
//            Button(onClick = {
//                count3++
//                lastClicked = "Pobeda"
//            }) {
//                Text("Pobeda",
//                    fontSize = 25.sp)
//            }
//        }
//    }
//}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartaPreview() {
    UraTheme {
        Carta()
    }
}
