package com.example.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeModifier : ComponentActivity() {
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
fun ModifierEx(){
    Column {
        //step 1 : modifier에 Modifier.fillMaxSize()를 사용해본다
//    Button(onClick = {}, modifier = Modifier.fillMaxSize()) {
//        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "Search")
//    }

        //step 2 : fillMaxSize()대신 Modifier.height,width설정해본다
        Button(onClick = {}, modifier = Modifier
            .width(200.dp)
            .height(100.dp)) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        //step 3 : size에 width,hegith를 인자로 넣을 수 있다
        Button(onClick = {}, modifier = Modifier.size(250.dp,100.dp)) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        //step 4 : background를 설정해본다 (버튼에서는 되지 않음)
        //Buton에 되지 않으면 Text,Icon에 해본다
        Button(onClick = {}, modifier = Modifier.size(250.dp,100.dp)
            .background(Color.Red)) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        //step 5 : Button의 Modifier에 padding을 추가해본다
        //contentpadding은 버튼 안의 콘텐츠에 padding을 준다.
        Button(onClick = {}, modifier = Modifier.size(250.dp,100.dp).padding(10.dp)) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        //step 6 : Button의 enabled를 false로 설정하고 Text의 modifier에
        //clickable을 넣어본다
        Button(onClick = {}, modifier = Modifier.size(250.dp,100.dp).padding(20.dp),
            enabled = false) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search", modifier = Modifier.clickable {  })
        }


        //step 7 : Text의 modifier에 offset을 설정하고 x파라미터를 설정해본다.
        //marginTop,Bottom느낌
        Button(onClick = {}, modifier = Modifier.size(250.dp,100.dp)) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null,
                modifier = Modifier.background(Color.Blue))
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing).background(Color.Black))
            Text(text = "Search", modifier = Modifier.offset(x = 10.dp, y = 20.dp)
                .background(Color.Magenta))
        }

    }

}


@Composable
@Preview(showBackground = true)
fun DefaultModifierPreView() {
    AndroidComposeTheme() {
        ModifierEx()
    }
}
