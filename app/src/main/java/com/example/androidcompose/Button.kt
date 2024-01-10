package com.example.androidcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeButton : ComponentActivity() {
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
                        Toast.makeText(this,"버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun CreateButton(onButtonClick : () -> Unit){

    Column {
        val buttonBorderGradient = Brush.horizontalGradient(listOf(Color.Green, Color.Red))
        //step 1 : 버튼 클릭 시 토스트메시지 출력
        Button(onClick = onButtonClick) {
            Text(text = "Send")
        }

        //step 2 : Icon을 text앞에 추가해본다
        //imageVector에는 Icons.Filled.Send
        //contentDescription에는 null
        Button(onClick = onButtonClick) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Text(text = "Send")
        }

        //step 3 : 아이콘과 텍스트 사이에 Spacer를 넣어준다.
        //modifier에 Modifier.size를 넣고 사이즈를
        // ButtonDefaults.IconSpacing을 넣어준다.
        Button(onClick = onButtonClick) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        //step 4 : enalbed를 설정해본다
        Button(onClick = onButtonClick, enabled = false) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        //step 5 : border 에  BorderStroke를 설정해본다
        Button(onClick = onButtonClick, border = BorderStroke(10.dp, buttonBorderGradient)) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        //step 6 : shape 을 CircleShape로 지정한다
        Button(onClick = onButtonClick, shape = RoundedCornerShape(10.dp)) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        //step 7 : colors를 설정해본다
        //ButtonDefaults.buttonColors 속성을 활용하여 부분 별 색상을 지정할 수 있다.
        //containerColor = 컨테이너 색, contentColor = 컨텐츠 색
        //disabledContainerColor = 비활성화 시 컨테이너 색, disabledContentColor= 비활 시 콘텐츠 색
        Button(onClick = onButtonClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.Green)) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        //step 8 : contentPadding에 PaddingValues를 설정해본다
        // elevation으로 그림자를 설정해본다
        Button(onClick = onButtonClick, contentPadding = PaddingValues(5.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)) {
            Icon(imageVector = Icons.Filled.Send, contentDescription =null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }


    }
}

@Composable
@Preview(showBackground = true)
fun DefaultbuttonPreView() {
    AndroidComposeTheme() {
        CreateButton(onButtonClick = {})
    }
}

