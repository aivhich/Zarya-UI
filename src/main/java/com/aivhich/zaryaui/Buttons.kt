package com.aivhich.justui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainButton(content:()->Unit,
               backgroundColor: Color,
               contentColor:Color,
               onClick:()->Unit,
               modifier: Modifier){
    Button(onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = modifier
    ){
        content()
    }
}
