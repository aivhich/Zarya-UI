package com.aivhich.zaryaui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

//h1
@Composable
fun HeadlineText(text:String, textAlign: TextAlign){
    Text(text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign)
}

//h2
@Composable
fun SubheadingText(text:String, textAlign: TextAlign){
    Text(text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign)
}

//h3
@Composable
fun BodyText(text:String, textAlign: TextAlign){
    Text(text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign)
}

//h4
@Composable
fun SubText(text:String, textAlign: TextAlign){
    Text(text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign)
}