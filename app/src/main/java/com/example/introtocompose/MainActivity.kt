package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    var moneyCounter = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF546E7A)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Text(text = "$${moneyCounter.value}", style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter = moneyCounter.value) {
                moneyCounter.value = it + 1
            }

        }

    }
}

@Composable
fun CreateCircle(moneyCounter: Int = 0, updateMoneyCounter: (Int) -> Unit) {


//    var moneyCounter by remember{
//        mutableStateOf(0)
//    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
                updateMoneyCounter(moneyCounter)
        },
        shape = CircleShape,
        elevation = 4.dp) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap $moneyCounter", modifier = Modifier)
        }


    }
}


@Preview(name = "Me", showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}