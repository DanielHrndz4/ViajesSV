package com.danielhrndz.viajessv.components.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielhrndz.viajessv.R
import com.danielhrndz.viajessv.ui.theme.blueBar
import com.danielhrndz.viajessv.ui.theme.lightGray

data class  BottomNavigationItem(
    val title:String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    )

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(module: @Composable () -> Unit) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.homeactive),
            unselectedIcon = painterResource(id = R.drawable.home),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Calender",
            selectedIcon = painterResource(id = R.drawable.calenderactive),
            unselectedIcon = painterResource(id = R.drawable.calendar),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Search",
            selectedIcon = painterResource(id = R.drawable.search),
            unselectedIcon = painterResource(id = R.drawable.search),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Mensajes",
            selectedIcon = painterResource(id = R.drawable.messageactive),
            unselectedIcon = painterResource(id = R.drawable.message),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Perfil",
            selectedIcon = painterResource(id = R.drawable.profileactive),
            unselectedIcon = painterResource(id = R.drawable.profile),
            hasNews = false,
        ),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0)}
    Scaffold(
        bottomBar = {
            NavigationBar(modifier = Modifier.height(100.dp)) {
                items.forEachIndexed{ index, item ->
                    NavigationBarItem(selected = selectedItemIndex == index,
                        onClick = {
                        selectedItemIndex = index
                        },
                        modifier = Modifier.padding(vertical = 10.dp),
                        label = {
                                Text(
                                    text = if (item.title == "Search"){ "" } else item.title,
                                    color = if (index == selectedItemIndex) {
                                        blueBar
                                    } else lightGray,
                                )
                        },
                        icon = { BadgedBox(
                            badge = {
                                if(item.badgeCount != null){
                                    Badge{
                                        Text(text = item.badgeCount.toString())
                                    }
                                }else if(item.hasNews){
                                    Badge()
                                }
                            }
                        ) {
                            Image(
                                painter = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .then(
                                        if (item.title == "Search") {
                                            Modifier
                                                .background(blueBar)
                                                .padding(15.dp)
                                        } else {
                                            Modifier
                                        }
                                    )
                            )
                        }
                        }
                    )
                }
            }
        }
    ) {
        module()
    }
}