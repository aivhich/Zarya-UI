package com.aivhich.zaryaui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun AvatarCircle(
    painter: Painter? = null,
    ABname: String,
    background: Color,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .then(modifier)
            .clip(CircleShape)
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (painter != null) {
            Image(
                contentScale = ContentScale.Fit,
                painter = painter,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            HeadlineText(text = ABname)
        }
    }
}