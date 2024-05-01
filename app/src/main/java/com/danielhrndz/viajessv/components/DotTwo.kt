package com.danielhrndz.viajessv.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danielhrndz.viajessv.ui.theme.blueBar
import com.danielhrndz.viajessv.ui.theme.lightBlue

@Composable
fun dotTwo(){
    Row ( Modifier.padding(vertical = 5.dp) ){
        Surface(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .fillMaxWidth()
                .padding(horizontal = 1.dp),
            shape = RoundedCornerShape(16.dp),
            color = lightBlue
        ){

        }
        Surface(
            modifier = Modifier
                .width(40.dp)
                .height(10.dp)
                .fillMaxWidth()
                .padding(horizontal = 1.dp),
            shape = RoundedCornerShape(16.dp),
            color = blueBar,
        ){

        }
        Surface(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp)
                .fillMaxWidth()
                .padding(horizontal = 1.dp),
            shape = RoundedCornerShape(16.dp),
            color = lightBlue
        ){
        }
    }
}