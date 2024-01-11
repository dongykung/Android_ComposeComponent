package com.example.androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class ProfileCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                ProfileCardEx(cardData)
            }
        }
    }
    companion object{
        var cardData = CardData(
            imageUri = "https://firebasestorage.googleapis.com/v0/b/chattingapp-c1231.appspot.com/o/8JJdr8wpIDeqVmFFkW67gSF2dC02%2F8JJdr8wpIDeqVmFFkW67gSF2dC02profile.jpg?alt=media&token=77679bf2-f641-4edd-9d86-398072125cabhttps://firebasestorage.googleapis.com/v0/b/chattingapp-c1231.appspot.com/o/8JJdr8wpIDeqVmFFkW67gSF2dC02%2F8JJdr8wpIDeqVmFFkW67gSF2dC02profile.jpg?alt=media&token=77679bf2-f641-4edd-9d86-398072125cab",
            imageDescription = "snow",
            author = "dongkyung",
            description = "snowgood"
        )
    }
}

@Composable
fun ProfileCardEx(cardData : CardData){
    val placeholderColor = Color(0x33000000)
    Column {
        Card(modifier = Modifier.padding(8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)) {

                //step 1 : AsyncImage, Spacer, Column, Text로 레이아웃을 만들어보자
                AsyncImage(model = cardData.imageUri, contentDescription =cardData.imageDescription,
                    modifier = Modifier.size(32.dp))
                Spacer(modifier = Modifier.size(8.dp))
                Column() {
                    Text(text = cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = cardData.description)
                }
            }
        }
            //step 2 : AsyncImage에서 Placeholder를 지정하고
            //contentScale을 ContentScale.Crop으로 설정
            //clip사용해서 둥근 외양 설정
        Card(modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)) {

                //step 1 : AsyncImage, Spacer, Column, Text로 레이아웃을 만들어보자
                AsyncImage(model = cardData.imageUri, contentDescription =cardData.imageDescription,
                    modifier = Modifier
                        .size(45.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    placeholder = ColorPainter(placeholderColor))
                Spacer(modifier = Modifier.size(8.dp))
                Column() {
                    Text(text = cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = cardData.description)
                }
            }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun DefaultProfileCardExPreView(){
    AndroidComposeTheme{
        ProfileCardEx(ProfileCard.cardData)
    }
}

data class CardData(
        val imageUri : String,
        val imageDescription : String,
        val author : String,
        val description : String
        )


