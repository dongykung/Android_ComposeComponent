package com.example.androidcompose

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcompose.ui.theme.AndroidComposeTheme

class MiniApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                    Surface(modifier = Modifier.fillMaxSize()) {
                        CatalogEx(itemList = items)
                    }
            }
        }
    }
}



@Composable
fun Item(itemData : ItemData){
        Card(elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
            modifier = Modifier.padding(16.dp)) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = itemData.imageId),
                        contentDescription =itemData.title,
                        modifier = Modifier.clip(RoundedCornerShape(25.dp)))
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = itemData.title, style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = itemData.description)
                }
        }
}


@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    AndroidComposeTheme {
        Item(
            ItemData(
                imageId =R.drawable.a1,
                title = "해변 놀이 공원",
                description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            )
        )
    }
}

@Composable
fun CatalogEx(itemList : List<ItemData>){
    //LazyColumn = 필요할 때만 보여주겟다 (리사이클러뷰나 리스트뷰 대체)
        LazyColumn{
            //items = LazyListScope에 해당되는 함
            items(itemList){
                Item(it)
            }
        }
}

@Composable
@Preview(showBackground = true)
fun DefaultCatalogPreview(){
    AndroidComposeTheme{
        CatalogEx(items)
    }
}

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String,
)




val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a2,
        title = "캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a3,
        title = "워터월드",
        description = "워터월드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a4,
        title = "미국의 캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a5,
        title = "라스베가스",
        description = "라스베가스입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a6,
        title = "호르슈 밴드",
        description = "호르슈 밴드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a7,
        title = "미국의 길",
        description = "미국의 길입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a8,
        title = "엔텔로프 캐년",
        description = "엔텔로프 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a9,
        title = "그랜드 캐년",
        description = "그랜드 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
)