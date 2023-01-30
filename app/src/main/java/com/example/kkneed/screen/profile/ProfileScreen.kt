package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.model.ButtonItemData
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.MyTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        topBar = {
            MyTopAppBar {}
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                MyAccInfo()
                Spacer(Modifier.size(0.dp, 24.dp))
                MyVerticalList(navController)
                Spacer(Modifier.size(0.dp, 24.dp))
                MyHorizonList(navController)
            }
        }

    }
}

@Composable
fun MyAccInfo() {
    Surface(color = MaterialTheme.colorScheme.secondaryContainer) {
        Row(modifier = Modifier.padding(top = 40.dp)) {
            Box(modifier = Modifier.size(110.dp)){
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                androidx.compose.material3.IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ){
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .size(30.dp)
                    ) {
                        Box(modifier = Modifier.size(20.dp), contentAlignment = Alignment.Center)
                        {
                            Icon(Icons.Sharp.Settings,null, tint = MaterialTheme.colorScheme.onBackground)
                        }

                    }
                }
            }

            Column {
                Text(
                    text = "康康NEED",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "康康ID：1234567",
                    style = MaterialTheme.typography.labelMedium
                )
                Row(
                    modifier = Modifier
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = {},
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("7", style = MaterialTheme.typography.labelMedium)
                            Text("关注", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    TextButton(
                        onClick = {},
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("7", style = MaterialTheme.typography.labelMedium)
                            Text("关注", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                    TextButton(
                        onClick = {},
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("7", style = MaterialTheme.typography.labelMedium)
                            Text("关注", style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }

            }
        }
    }

}

@Composable
fun MyVerticalList(navController: NavController) {
    val buttonItems = listOf<ButtonItemData>(
        ButtonItemData(Icons.Default.CheckCircle, "我的记录", AllScreen.History.route),
        ButtonItemData(Icons.Default.Menu, "我的订单", ""),
        ButtonItemData(Icons.Default.Favorite, "我的收藏", "")
    )
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(20.dp),
    ) {
        Box(
            modifier = Modifier
                .size(360.dp, 80.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                buttonItems.forEachIndexed { _, item ->
                    IconButton(
                        onClick = {
                            navController.navigate(item.route)
                        },
                        modifier = Modifier.padding(horizontal = 35.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(item.image, null)
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            Text(item.title, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyHorizonList(navController: NavController) {
    val buttomItems = listOf<ButtonItemData>(
        ButtonItemData(Icons.Default.CheckCircle, "我的记录", ""),
        ButtonItemData(Icons.Default.Menu, "我的订单", ""),
        ButtonItemData(Icons.Default.Favorite, "我的收藏", ""),
        ButtonItemData(Icons.Default.Phone, "联系客服", "")
    )
    val buttonColor = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground
    )
    Column {
        Surface(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(20.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(360.dp, 224.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    buttomItems.forEachIndexed { _, item ->
                        Button(
                            onClick = {
                                navController.navigate(item.route)
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = buttonColor
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(item.image, null)
                                Spacer(modifier = Modifier.padding(5.dp, 0.dp))
                                Text(item.title, style = MaterialTheme.typography.bodySmall)
                                Spacer(modifier = Modifier.padding(100.dp, 0.dp))
                                Icon(Icons.Default.KeyboardArrowRight, null, tint = Color.Black)
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.size(0.dp, 24.dp))
        Surface(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(20.dp),
        ){
            Box(
                modifier = Modifier
                    .size(360.dp, 56.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Button(
                    onClick = {
                        navController.navigate("")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = buttonColor
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Settings, null)
                        Spacer(modifier = Modifier.padding(5.dp, 0.dp))
                        Text("设置", style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier = Modifier.padding(112.dp, 0.dp))
                        Icon(Icons.Default.KeyboardArrowRight, null, tint = Color.Black)
                    }
                }
            }
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun Temp() {
    KKNeedTheme {
        val navController = rememberNavController()
        ProfileScreen(navController)
    }

}