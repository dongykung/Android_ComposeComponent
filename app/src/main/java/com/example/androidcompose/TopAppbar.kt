package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class TopAppbar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                TopAppBarEx()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarEx(){
    //step 1 : topappbar를 생성하고 title를 지정한다
    Column {
        //step 2 : navigationIcon 파라미터를 채워본다.
        //IconButton을 만들고 자식으로 Icon을 넣는다.
        TopAppBar(title = { Text(text = "Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="up navigation")
                }
            })

        //step 3 : actions를 추가해본다.
        //Icons.Filled에서 여러아이콘 사용
        TopAppBar(title = { Text(text = "Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="up navigation")
                }
            }, actions = {
                IconButton(onClick ={}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription ="setting")
                }
                IconButton(onClick ={}) {
                    Icon(imageVector = Icons.Filled.AccountBox, contentDescription ="accountbox")
                }
            })

    }
}


@Composable
@Preview(showBackground = true)
fun DefaultTopAppBarPreView(){
    AndroidComposeTheme{
        TopAppBarEx()
    }
}
