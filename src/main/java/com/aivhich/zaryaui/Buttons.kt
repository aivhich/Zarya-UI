package com.aivhich.zaryaui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    backgroundColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(25),
    modifier: Modifier = Modifier
        .shadow(3.dp, clip = true, shape = shape)
        .fillMaxWidth(0.9f)
        .height(48.dp),
    content: @Composable () -> Unit,
) {
    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = shape,
        modifier = Modifier
            .then(modifier)
    ) {
        content()
    }
}


@Composable
fun IconButton(
    painter: Painter,
    backgroundColor: Color = Color.Transparent,
    contentColor: Color = Color.Unspecified,
    onClick: () -> Unit,
    size: Dp = 24.dp,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.IconButton(onClick = { onClick() },
        modifier = Modifier.padding(0.dp).then(modifier),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )) {
        Icon(painter = painter,
            modifier = Modifier.size(size),
            tint = contentColor,
            contentDescription = "")
    }
}