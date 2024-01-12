package com.example.androidcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeScaffold : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                ScaffoldEx()
            }
        }
    }
}


@Composable
fun checkBoxWithContent(checked : Boolean,
                        toggleState : () -> Unit,
                        content : @Composable RowScope.() ->Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }) {
            Checkbox(checked = checked, onCheckedChange ={toggleState()})
            content()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldEx(){
    var checked by remember{ mutableStateOf(false) }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Scaffold App")
        }, navigationIcon = {
            IconButton(onClick = {}) {
                Image(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = {},modifier=Modifier.clickable {  }) {
            IconButton(onClick = {}) {
                Image(imageVector = Icons.Filled.Add, contentDescription ="")
            }
        }
    }){
        Surface(modifier = Modifier
            .padding(8.dp)
            .padding(paddingValues = it)) {
            checkBoxWithContent(checked=checked, toggleState = {checked=!checked}){
                Text(text = "컴포즈를 좋아합니다")
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultScaffoldPreView(){
    AndroidComposeTheme{
        ScaffoldEx()
    }
}