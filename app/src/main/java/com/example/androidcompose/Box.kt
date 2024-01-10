package com.example.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeBox : ComponentActivity() {
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
fun ComposeBoxEx(){
        //박스 자체를 만들거나, framelayout같이 중첩시킬 때 사용한다
    Column(modifier = Modifier.fillMaxSize()) {

        //step 1 : Text 두개를 Box안에 배치해본다
        Box(modifier = Modifier.size(200.dp)) {
            //BoxScope의 align임을 주의!!
            Text(text = "Hellow World",modifier=Modifier.align(Alignment.TopStart))
            Text(text = "JetPack Compose",modifier=Modifier.align(Alignment.BottomEnd))
            Text(text = "Compose",modifier=Modifier.align(Alignment.CenterStart))
        }


        //step 2 : 두 개의 Box를 Box안에 배치시키고 사이즈를 70에, 색상을 각기 다르게 해본다
        Box(modifier = Modifier.size(100.dp)){
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Cyan)
                .align(Alignment.CenterStart))
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd))
        }

        //step 3 : 부모 Box에 modifier 설정을 제거해서 콘텐츠 사이즈만큼 보여주게 한다.
        // 그리고 첫번 째 자식 Box의 사이즈를 matchParentSize()로 설정해본다
        Box{
            Box(modifier = Modifier.matchParentSize().background(Color.Cyan).align(Alignment.CenterStart))
            Box(modifier = Modifier.size(70.dp).background(Color.Cyan).align(Alignment.Center))
        }
    }

}

@Composable
@Preview(showBackground = true)
fun DefaultBoxPreView() {
    AndroidComposeTheme() {
        ComposeBoxEx()
    }
}