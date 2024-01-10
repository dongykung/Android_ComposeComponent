package com.example.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeBoxWithConstraints : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    CreateButton(onButtonClick = {
                        Toast.makeText(this,"버튼이 눌렸습니다", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}


@Composable
private fun Outer(){
    //step 2 : Inner의 인자로 Modifier.widthIn(min = 100.dp)를 전달해본다
    // heightIn도 전달해본다. 각각 인자의 max값도 전달해본다
    Column {
        Inner(modifier = Modifier
            .widthIn(min = 100.dp, max = 350.dp)
            .heightIn(min = 150.dp, max = 200.dp))
    }

}

// step 1 : Inner인자로 modifier를 전달해본다. 기본 값을 Modifier로 지정하기
// 파라미터로 받은 modifier를 BoxWithConstraints에 전달한다
@Composable
private fun Inner(modifier:Modifier=Modifier){
    BoxWithConstraints(modifier) {
        //step 3 : maxHeight 값이 150dp가 넘을 때만 추가로 텍스트를 출력해본다
        if(maxHeight>150.dp){
            Text(text = "여기 꽤 길군요!",modifier=Modifier.align(Alignment.BottomCenter))
        }
        Text(text = "maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight")
    }

}

@Preview(showBackground = true)
@Composable
fun DeafaultBoxWithConstraintsView(){
    AndroidComposeTheme{
        Outer()
    }
}