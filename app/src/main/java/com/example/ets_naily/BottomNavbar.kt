package com.example.ets_naily

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object List : Screen("list", "List", Icons.Outlined.List)
    object LiveChat : Screen("livechat", "LiveChat", Icons.Outlined.Phone)
    object Profile : Screen("profile", "Profile", Icons.Outlined.AccountCircle)
}

@Composable
fun BottomNavBar() {
    val screens = listOf(
        Screen.Home,
        Screen.List,
        Screen.LiveChat,
        Screen.Profile
    )
    Column {
        Divider(
            color = Color.Black.copy(alpha = 0.2f),
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            screens.forEach { screen ->
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title,
                    modifier = Modifier.padding(16.dp),
                    tint = Color(0xFFC83C44)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavbarPreview(){
    BottomNavBar()
}


