package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ComposeSlotAPI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                SlotAPIEx()
            }
        }
    }
}

//step 1 : 'Row'를 @Composable 함수로 분리해본다.
//checked의 값, Text의 'text'를 인자로 전달한다.
@Composable
fun CheckboxWithText(checked:MutableState<Boolean>,text:String){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked.value, onCheckedChange ={checked.value=it})
        Text(text = text, modifier = Modifier.clickable { checked.value=!checked.value })
    }
}


//step 2 : @Composable 함수에서 '@Composable () -> Unit' 타입으로 'content'를 받아온다.
//'Row'의 'Text'를 빼고 'content()' 를 넣는다.
//'Row' Modifier.clickable 를 넣어 전체 클릭가능하게한다.
@Composable
fun CheckboxWithSlotAPI(checked:MutableState<Boolean>,content : @Composable () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { checked.value=!checked.value }) {
        Checkbox(checked = checked.value, onCheckedChange ={checked.value=it})
        content()
    }
}



//step 3 : 'content' 의 타입을 '@Composable RowScope.() -> Unit' 로 바꾼다.
//이렇게 다른 Composable 콘텐트를 넣는 방법을 Slot API 라고 한다.
@Composable
fun CheckboxWithSlotAPI2(checked:MutableState<Boolean>,content : @Composable RowScope.() -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { checked.value=!checked.value }) {
        Checkbox(checked = checked.value, onCheckedChange ={checked.value=it})
        content()
    }
}

//step 4 : 상태를 바꾸는 람다를 'Composable' 함수의 인자 뺀다.
//인자에서 MutableState 대신 boolean 값으로 변경
@Composable
fun CheckboxWithSlotAPI3 (checked:Boolean,
    onCheckedChange : () ->Unit
    ,content : @Composable RowScope.() -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange() }) {
        Checkbox(checked = checked, onCheckedChange ={onCheckedChange()})
        content()

    }
}




@Composable
fun SlotAPIEx(){
    val checked1 = remember { mutableStateOf(false) }
    val checked2 = remember { mutableStateOf(false) }

    var unitcheck by remember { mutableStateOf(false) }
    var unitcheck2 by remember{ mutableStateOf(false)}
        Column {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(checked = checked1, onCheckedChange ={checked1=it})
//                Text(text = "텍스트1", modifier = Modifier.clickable { checked1=!checked1 })
//            }
            CheckboxWithText(checked1,"Text1")


//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(checked = checked2, onCheckedChange = setchecked2)
//                Text(text = "텍스트2", modifier = Modifier.clickable { setchecked2(!checked2)})
//            }
            CheckboxWithText(checked2,"Text2")

            CheckboxWithSlotAPI(checked1, content = {Text(text = "slot text1")})
            CheckboxWithSlotAPI(checked2) { Text(text = "slot text2") }

            CheckboxWithSlotAPI2(checked1, content = {
                Text(text = "slot rowscope text1", modifier = Modifier.align(Alignment.Bottom))})
            CheckboxWithSlotAPI2(checked2) {
                Text(text = "slot rowscope text2", modifier = Modifier.align(Alignment.Top))}


            CheckboxWithSlotAPI3(checked = unitcheck,
                onCheckedChange = {
                    unitcheck=!unitcheck
                },
                content = {
                Text(text = "slot unit2 text1", modifier = Modifier.align(Alignment.Bottom))})
            CheckboxWithSlotAPI3(checked = unitcheck2,
                onCheckedChange = {
                    unitcheck2=!unitcheck2
                }){
                Text(text = "slot unit2 text2", modifier = Modifier.align(Alignment.Top))}
        }
}



@Composable
@Preview(showBackground = true)
fun DefaultSlotAPIPreView(){
    AndroidComposeTheme{
        SlotAPIEx()
    }
}