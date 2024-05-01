package com.danielhrndz.viajessv.model

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.danielhrndz.viajessv.ui.theme.blueBar
import com.danielhrndz.viajessv.ui.theme.lightGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun onboard01(navController: NavHostController, image: Int, dotFunction: @Composable () -> Unit, onboard:String) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "OnBoard01",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(
                    text = "La vida es corta y el mundo es ancho",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 17.dp, end = 17.dp, top = 35.dp, bottom = 15.dp)
                )
                Text(
                    text = "En Friends tours and travel, personalizamos viajes educativos confiables y dignos de confianza a destinos de todo el mundo.",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    color = lightGray,
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                )
                dotFunction()
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ElevatedButtonExample(onClick = { navController.navigate(onboard) })
                }
            }
        }
    }
}
@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(
        onClick = { onClick() },
        Modifier.width(350.dp),
        colors = ButtonDefaults.buttonColors(containerColor = blueBar),
    ) {
        Text(
            text = "Siguiente",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
        )
    }
}