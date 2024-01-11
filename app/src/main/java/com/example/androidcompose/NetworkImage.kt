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
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class NetworkImage: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                NetworkImageEx()
            }
        }
    }

}

@Composable
fun NetworkImageEx(){
    Column {
        //step 1 : rememberImagePainter를 이용해 Image의 painter를 설정한다
        //(Compose 한국어 문서의 추천, deprecated됨)
        //remebmer = 기억했다가 다시 호출될 때 다시 씀
        val painter = rememberImagePainter(data ="https://firebasestorage.googleapis.com/v0/b/chattingapp-c1231.appspot.com/o/8JJdr8wpIDeqVmFFkW67gSF2dC02%2F8JJdr8wpIDeqVmFFkW67gSF2dC02profile.jpg?alt=media&token=77679bf2-f641-4edd-9d86-398072125cab")
        Image(painter = painter, contentDescription ="snow")



        //step 2 : AsyncImage를 이용해본다. model에 주소를 적으면 됨
        AsyncImage(model ="https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg" , contentDescription ="image")
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultNetworkImagePreView(){
    AndroidComposeTheme{
        ImageEx()
    }
}




