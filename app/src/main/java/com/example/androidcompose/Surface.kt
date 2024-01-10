package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeSurface : ComponentActivity() {
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
fun SurfaceEx(){
    //Surface는 뒤에 터치를 전달하지 않는다
    //기본적으로 UI를 구축하는 기반이 된다
    //성능적으로 text가 margin을 가져야 된다면  text에 5dp padding을 설정하는게아니라
    //Surface에 padding을 5dp 설정하는것이 성능적으로 좋다


    Column {
        //step 1 : elevation을 설정해본다
        //tonalElevation 과 shadowEleavtion 차이점을 알아본다.
        Surface(modifier = Modifier.padding(5.dp),
            tonalElevation = 10.dp) {
            Text(text = "Hello", modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.size(10.dp))

        Surface(modifier = Modifier.padding(5.dp),
           shadowElevation = 25.dp) {
            Text(text = "Hello",modifier = Modifier.padding(8.dp))
        }

        //step 2 : border의 값을 설정해본다
        Surface(
            border = BorderStroke(2.dp, Color.Magenta),
            shadowElevation = 20.dp,
            modifier = Modifier.padding(3.dp)
        ) {
            Text(text = "Hello",modifier = Modifier.padding(8.dp))
        }


        //step 3: shape을 설정해본다
        Surface(modifier = Modifier.padding(5.dp),
            shape = CircleShape) {
            Text(text = "Hello",modifier = Modifier.padding(8.dp))
        }

        //step 4 : color 를 설정해본다
        Surface(modifier = Modifier.padding(5.dp),
            shadowElevation = 25.dp,
            color = MaterialTheme.colorScheme.primary, //만약 contentColor가 지정되지 않았다면 OnPrimary색으로 지정됨
            //즉 color가 surface라면 contentcolor = onsurface, 이런식으로 지정이 된다
            contentColor = Color.Blue) {
            Text(text = "Hello",modifier = Modifier.padding(8.dp))
        }

    }

}


@Composable
@Preview(showBackground = true)
fun DefaultSurfacePreView() {
    AndroidComposeTheme() {
        SurfaceEx()
    }
}