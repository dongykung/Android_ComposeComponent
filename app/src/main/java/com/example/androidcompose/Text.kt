package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeText : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    CreateText("dongkyung")
                }
            }
        }
    }
}

@Composable
fun CreateText(name: String){
    Column {
        Text(text="Hellow $name")

        //step 1 : 색상을 지정하기 위해 color 파라미터에 Color.RED 전달
        Text(text="Color $name", color =Color.Red)

        //step 2 : Color 객체를 이용해서 해쉬코드값으로 색상전달
        Text(text = "Color $name",color = Color(0xffff9944))

        //step 3 : fontSize 로 글자 크기를 변경해본다
        Text(text = "fontSize $name", fontSize = 30.sp)

        //step 4 : fontWeight 에 fontWeight.BOLD를 전달해본다
        Text(text = "fontWeight $name", fontWeight = FontWeight.Bold)

        //step 5 : fontFamily에 FontFamily.Cursive 전달해본다
        Text(text = "fontFamily $name", fontFamily = FontFamily.Cursive)
        Text(text = "fontFamily $name", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold)

        //step 6 : letterSpacing 을 지정해본다 sp 지정
        Text(text = "LetterSpacing $name", letterSpacing = 2.sp)

        //step 7 : maxLine을 1 로 지정해보자
        Text(text = "MaxLine Test\nMaxLine Test", maxLines = 1)

        //step 8 : TextDecoration에 TextDecoration.Underline을 추가해보자
        Text(text = "TextDecoration $name", textDecoration = TextDecoration.Underline)

        //step 9 : textAlign을 TextAlign.Center로 지정한다
        Text(text = "Hellow $name", modifier = Modifier.width(200.dp).height(200.dp),
            textAlign = TextAlign.Center)

    }

}

@Composable
@Preview(showBackground = true)
fun DefaultTextPreView() {
    AndroidComposeTheme() {
        CreateText("Android")
    }
}

