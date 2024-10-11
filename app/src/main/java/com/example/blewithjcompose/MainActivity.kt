package com.example.blewithjcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blewithjcompose.ui.theme.BLEWithJComposeTheme
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BLEWithJComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun GreetingPreview() {
        BLEWithJComposeTheme {
            Greeting("Rikai")
        }
    }

    @Composable
    fun listSimple() {
        LazyColumn {
            //Add a single item
            item {
                Text(text = "Cái đầu")
            }
            //Add 3 items
            items(3) { index ->
                Text(text = "Day thu 2: $index")
            }
            //Add
            items(2) { index ->
                Text(text = "Day thu 3: $index")
            }
            //Add onother 1 String
            item {
                Text(text = "footer")
            }
        }
    }

    private val countryList = mutableListOf("VietNam", "Japan", "America", "Italy")
    private val listModifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
        .padding(12.dp)
    private val textStyle =
        androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.Black)

    @Composable
    fun simpleListTest() {
        LazyColumn(modifier = listModifier) {
            items(countryList){
                country ->
                Text (text = country, style = textStyle)
            }
        }
    }

    data class FruitModel(val name: String , val image: Int)

    private val fruitList = mutableListOf<FruitModel>()

    @Composable
    fun ListRow(model: FruitModel){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(Color.Green)
        ){
            Image(
                painter =
                    painterResource(id = model.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }

    @Composable
    fun customLazycolumn(){
        fruitList.add(FruitModel("Fruit 1", R.drawable.cherry))
        fruitList.add(FruitModel("Fruit 2", R.drawable.watermelon))
        fruitList.add(FruitModel("Fruit 3", R.drawable.orange))
        fruitList.add(FruitModel("Fruit 4", R.drawable.ic_launcher_background))
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(fruitList){
                model ->
                ListRow(model = model)
            }
        }
    }

//    @Composable
//    fun ScaffoldSamplee(){
//        val scaffoldState =
//            rememberBottomSheetScaffoldState(rememberBottomSheetScaffoldState(DrawerValue.Closed))
//        Scaffold (
//             = scaffoldState
//        ) {  }
//    }

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun scaffoldSampleWithTopBar(){
    Scaffold (
        topBar = { myTopBarr() },
        content = {myMainContent()},
        bottomBar = { myBottomBarrr() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopBarr(){
    TopAppBar(
        title = {
            Row {
                Text(
                    text = "Noi dung 1",
                    fontSize = 30.sp,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Noi dung 2",
                    fontSize = 30.sp,
                    color = Color.Red
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        }
    )
}
@Composable
fun myMainContent() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .background(Color.Green),
            text = "Content of the page",
            fontSize = 30.sp,
            color = Color.Red,
            style =  MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun myBottomBarrr(){
    val selectedIndex = remember { mutableStateOf(1) }
    NavigationBar() {
        for (i in 0..2)
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home,"")},
            label = {Text(text = "Nhà")},
            selected = (selectedIndex.value == 0),
            onClick = { selectedIndex.value = 0  }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Info,"")},
            label = {Text(text = "ThongTin")},
            selected = (selectedIndex.value == 1),
            onClick = { selectedIndex.value = 1  }
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Build,"")},
            label = {Text(text = "Sét ting")},
            selected = (selectedIndex.value == 2),
            onClick = { selectedIndex.value = 2  }
        )
    }
}

