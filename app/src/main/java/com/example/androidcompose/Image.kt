package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeImage : ComponentActivity() {
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
fun ImageEx(){
    Column {

        //step 1 : Image를 만들어보고
        //painter 항목에 painterResource(id=R.drawable.사진.png)
        //contentDescription에 설명을 넣을 수 있음
        Image(painter = painterResource(id = R.drawable.defaultimage) , contentDescription ="defaultImage")

        //step 2 : imageVector를 사용해서 이미지를 넣어본다
        Image(imageVector = Icons.Filled.Settings, contentDescription = "setting")
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultImagePreView(){
    AndroidComposeTheme{
        ImageEx()
    }
}