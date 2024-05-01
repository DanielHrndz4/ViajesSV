package com.danielhrndz.viajessv

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danielhrndz.viajessv.components.dotOne
import com.danielhrndz.viajessv.components.dotThree
import com.danielhrndz.viajessv.components.dotTwo
import com.danielhrndz.viajessv.model.loadingScreen
import com.danielhrndz.viajessv.model.onboard01
import com.danielhrndz.viajessv.screen.Home
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SuspiciousIndentation", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController  = rememberNavController()
            var isLoading by remember { mutableStateOf(true) }
            var destination by remember { mutableStateOf<String>("") }

            lifecycleScope.launch(Dispatchers.IO) {
                delay(3000)
                withContext(Dispatchers.Main){
                    val flag = true
                    destination = verify(flag)
                    isLoading = false
                }
            }

            if (isLoading) {
                loadingScreen()
            }else{
                NavHost(navController = navController, startDestination = destination){
                    composable("Onboard01") {
                        onboard01(navController = navController, image = R.drawable.onboard01, { dotOne() }, "Onboard02")
                    }
                    composable("Onboard02"){
                        onboard01(navController = navController, image = R.drawable.onboard02, { dotTwo() }, "Onboard03")
                    }
                    composable("Onboard03"){
                        onboard01(navController = navController, image = R.drawable.onboard03, { dotThree() }, "Home")
                    }
                    composable("Home"){
                        Home()
                    }
                }
            }
        }
    }
}

fun verify(flag: Boolean): String {
    var isTrue = "";
    if(flag){
        isTrue = "Onboard01"
    }else{
        isTrue = "Home"
    }
    return isTrue
}