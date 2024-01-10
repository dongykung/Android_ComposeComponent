package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}



@Composable
fun ColumnEx(){
    Column {
        //step 1 : horizontalAlignment를 적용해본다
        Column(modifier = Modifier.size(100.dp), horizontalAlignment = Alignment.End) {
            Text(text = "첫 번째", modifier = Modifier.align(Alignment.Start))
            Text(text = "두 번째", modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = "세 번째")
        }

        //step 2 : Column에 verticalArragement를 지정해본다.
        // Top, Bottom, SpaceAround(균등 배치), SpaceBetween(벽 붙이고 공백), SpaceEvenly(동일하게 사이즈 배치)의 차이점을 알아본다
        Column(modifier = Modifier.size(100.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "첫 번째", modifier = Modifier.align(Alignment.Start))
            Text(text = "두 번째", modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = "세 번째")
        }

        //text를 가운데 오게하기위해 text의 속성 textAlign 사용해본다
        Column(modifier = Modifier.size(100.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "첫 번째", modifier = Modifier.align(Alignment.Start))
            Text(text = "두 번째", modifier = Modifier.align(Alignment.CenterHorizontally), textAlign = TextAlign.Center)
            Text(text = "세 번째")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultColumnPreView() {
    AndroidComposeTheme() {
        ColumnEx()
    }
}
