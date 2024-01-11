package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeTextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                TextFieldEx()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEx(){
    var name by remember { mutableStateOf("Tom") }
    val (name2,setname2) = remember{ mutableStateOf("") }
    var name3 = remember{ mutableStateOf("")}
        Column(modifier=Modifier.padding(8.dp)) {
            //step 1 : TextField를 text위에 만든다.
            TextField(value ="Tom", onValueChange = {})

            //step 2 : text에 Android대신 TextField의 입력을 출력하게한다.
            //mutableStateOf("")를 사용
            TextField(value = name, onValueChange ={name = it})


            //step 3 : TextField에 label을 추가하고 내용에는 'Text("Name")'을 채워본다
            TextField(value = name, label = { Text(text = "이름")}, onValueChange ={name=it})
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Hello $name")
            //step 4 : TextField 와 Text 사이에 Spacer을 넣는다


            //step 5 : TextField를 OutlinedTextField로 변경해본다
            OutlinedTextField(value = name2, label ={ Text(text = "이름")} , onValueChange =setname2)
            OutlinedTextField(value = name3.value, label ={ Text(text = "이름")} , onValueChange ={name3.value=it})

        }
}


@Composable
@Preview(showBackground = true)
fun DefaultTextFieldView(){
    AndroidComposeTheme{
        TextFieldEx()
    }
}