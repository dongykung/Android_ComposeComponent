package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeRow : ComponentActivity() {
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
fun RowEx(){

    Column {
        //step 1 : Text의 modifier align을 설정해본다.
        //Alignment.TOP,CenterVertically,Bottom을 설정해보자
        //Row 자체가 horizontal이기 때문에 align은 vertical에 대해서만 적용이 된다.
        Row(modifier=Modifier.height(40.dp)) {
            Text(text = "첫 번째!",modifier=Modifier.align(Alignment.Top))
            Text(text = "두 번째!", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
        }

        //구분선
        Spacer(modifier = Modifier
            .width(200.dp)
            .height(10.dp)
            .background(Color.Yellow))

        //step 2 : Row에 verticallAligment를 설정해본다
        //Text에 align에 사용할 때 쓰이는 값들과 같다
        Row(modifier=Modifier.height(40.dp),
            verticalAlignment = Alignment.Bottom) {
            Text(text = "첫 번째!")
            Text(text = "두 번째!")
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Top))
        }
        //구분선
        Spacer(modifier = Modifier
            .width(200.dp)
            .height(10.dp)
            .background(Color.Yellow))


        //step 3 : Row의 width를 200dp 로 설정하고
        //Row에 horizontalArrangment에 Arrangement.Center를 설정해본다
        // Start, End, SpaceAround(균등 배치), SpaceBetween(벽 붙이고 공백), SpaceEvenly(동일하게 사이즈 배치)의 차이점을 알아본다
        //row에 대해서 적용됨 (수평 적용)
        Row(modifier= Modifier
            .width(200.dp)
            .height(40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "첫 번째!")
            Text(text = "두 번째!")
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Top))
        }

        Spacer(modifier = Modifier
            .width(200.dp)
            .height(10.dp)
            .background(Color.Yellow))


        //step 4 : horizontalArrangement를 제거하고 각 Text에
        //Modifier.weight를 설정해본다. 각 항목의 값도 변경해본다
        Row(modifier= Modifier
            .width(200.dp)
            .height(40.dp),
            verticalAlignment = Alignment.Bottom) {
            Text(text = "첫 번째!", modifier = Modifier
                .weight(3f)
                .align(Alignment.CenterVertically))
            Text(text = "두 번째!",modifier = Modifier.weight(3f))
            Text(text = "세 번째!,", modifier = Modifier
                .align(Alignment.Top)
                .weight(3f))
        }

        Spacer(modifier = Modifier
            .width(200.dp)
            .height(10.dp)
            .background(Color.Yellow))

        //step 5 : Text 대신 Icon을 넣어본다
        //text를 가운데 오게하기위해 text의 속성 textAlign 사용해본다
        Row(modifier= Modifier
            .width(200.dp)
            .height(40.dp),
            verticalAlignment = Alignment.Bottom) {
            Text(text = "첫 번째!", modifier = Modifier
                .weight(3f)
                .background(Color.Magenta)
                .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center)
           Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "추가")
            Text(text = "세 번째!,", modifier = Modifier
                .align(Alignment.Top)
                .weight(3f), color = Color.Cyan, textAlign = TextAlign.End)
        }

    }

}


@Composable
@Preview(showBackground = true)
fun DefaultRowPreView() {
    AndroidComposeTheme() {
        RowEx()
    }
}