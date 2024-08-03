package com.aivhich.zaryaui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UsualPanel(
    subtext: String? = null,
    background: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        Modifier.then(modifier),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        if (subtext != null) {
            SubText(
                text = subtext,
                color = Color.DarkGray,
                modifier = Modifier.padding(5.dp, 2.dp)
            )
        }
        Column(
            Modifier
                .shadow(2.dp, RoundedCornerShape(20.dp))
                .background(background, RoundedCornerShape(20.dp))
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}


@Composable
fun StatisticBlockPanel(
    firstWord: String, secondWord: String, thirdWord: String,
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxHeight()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BodyText(text = firstWord)
        Spacer(modifier = Modifier.height(5.dp))
        MegaText(text = secondWord)
        Spacer(modifier = Modifier.height(5.dp))
        BodyText(text = thirdWord)
    }
}