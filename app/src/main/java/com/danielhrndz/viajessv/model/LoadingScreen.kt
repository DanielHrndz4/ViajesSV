package com.danielhrndz.viajessv.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.danielhrndz.viajessv.ui.theme.blueBar

@Preview
@Composable
fun loadingScreen(){
    Column (
        Modifier
            .fillMaxSize()
            .background(color = blueBar),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "ViajesSV", color = Color.White, fontSize = 66.sp, fontWeight = FontWeight.Medium)
    }
}