package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class CheckBox: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                CheckBoxdEx()
            }
        }
    }

}

//checkboxex()
//checkboxec2() 함수
//setContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxdEx(){
   Column {

       Row(verticalAlignment = Alignment.CenterVertically) {
            //step 1 : CheckBox를 만들어보고 checked의 속성은 false
           //onCheckedChange는 비워둔다
           //checked값이 바뀌지 않으면 변경되지 않음
           Checkbox(checked = false, onCheckedChange = {})
           Text(text = "프로그래머입니까?")
       }
       Row(verticalAlignment = Alignment.CenterVertically){
           //step 2 : onCheckedChange에서 boolean값 변수를 바꾸고
           //checked에서 그 값을 반영해본다 (잘 되지 않음)
           var checked = false  //checked가 composoble함수나 recomposition이 아님
           //상태가 바뀌어야 하는데 만든 checked는 상태가 아님
           //Composoble은 언제든지 다시 그려질 수 있고 상태가 날아갈 수 있다.
           //중간에 중단될 수도 있고 새로 시작될 수도 있고 여러 쓰레드에서 동시에 여러 composoble을 그리고 있을 수 있다.

           Checkbox(checked =checked , onCheckedChange ={
               checked=!checked
           } )
           Text(text = "프로그래머입니까?")
       }

       Row(verticalAlignment = Alignment.CenterVertically){
           //step 3 : boolean대신 remember {mutableStateOf(false)}를
           //사용하여 상태를 도입해본다 (value 프로퍼티를 이용해야 함)
           var checked = remember{mutableStateOf(false)}  //바뀔 수 있는 상태 swift의 State와 비슷함
           //remember는 상태를 기억했다가 나중에 다시 쓰게해달라
           //그리는 과정(Composoble함수에)에 상태객체를 만들었다. remember를 사용해야함

           //destruction //비구조화, 반구조화, 구조분해
           //val (a,b) = listOf(2,3)

           Checkbox(checked =checked.value , onCheckedChange ={
               checked.value=!checked.value
           } )
           Text(text = "프로그래머입니까? remember")
       }

       //값이 바뀌고 바뀌었기 때문에 체크박스가 다시 렌더링 됨 = recomposition(다시 렌더링 되는 과정) = 재구축
       //compose에서는 다시 그려지는 과정이 반복이 되는데 이를 recomposition이라고 하고 상태가 바뀌었을 때
       //recomposition이 이루어짐


       Row(verticalAlignment = Alignment.CenterVertically){
           //위임된 속성
           //var checked = remember{mutableStateOf(false)}  //바뀔 수 있는 상태 swift의 State와 비슷함
           //remember는 타입을 기억만해주고 그대로 전달
           //step 4 : delegated properties로 변경해본다
           //import androidx.compose.runtime.getValue
           //import androidx.compose.runtime.setValue
           var checked by remember {mutableStateOf(false)}
           Checkbox(checked = checked, onCheckedChange ={checked=it} )
           Text(text = "프로그래머입니까? by remember")
       }

       Row(verticalAlignment = Alignment.CenterVertically){
          //step 5 : destruction으로 상태를 받아서 사용해본다
           //checked가 getter라면 setChecked는 setter가 됨
          val (checked,setChecked) = remember{mutableStateOf(false)}
           Checkbox(checked = checked, onCheckedChange =setChecked)
           //checkbox
           Text(text = "프로그래머입니까? destruction",
               modifier = Modifier.clickable { setChecked(!checked) })
       }
   }
}


@Composable
@Preview(showBackground = true)
fun DefaultCheckBoxExPreView(){
    AndroidComposeTheme{
        CheckBoxdEx()
    }
}



