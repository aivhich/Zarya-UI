package com.aivhich.zaryaui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ChipColors
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aivhich.justui.R


@Composable
fun UsualProgressBar(progress: Float,  modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth()
            ) {
                LinearProgressIndicator(
                    progress = {
                        progress
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    color = MaterialTheme.colorScheme.tertiary,
                    strokeCap = StrokeCap.Round,
                )
                HeadlineText(text = "${(progress * 100).toInt()}%")
            }
        }
    }
}


@Composable
fun Appbar(allstrikes: Int, maxval:Int, painter: Painter) {
    //var route:String = navController.graph.route.toString()
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier.shadow(
            10.dp,
            RectangleShape,
            clip = true,
            ambientColor = MaterialTheme.colorScheme.tertiary,
            spotColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
        ) {
            LinearProgressIndicator(
                progress = {
                    (allstrikes/maxval).toFloat()
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(20.dp)
                    .clip(RoundedCornerShape(20.dp)),
                color = MaterialTheme.colorScheme.tertiary,
                strokeCap = StrokeCap.Round,
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(IntrinsicSize.Min)
            ) {
                Icon(
                    painter = painter,
                    "",
                    tint = Color(0xFFFF9800),
                    modifier = Modifier.size(24.dp)
                )
                HeadlineText(text = "$allstrikes")
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterWidget(list: List<String>){

    val listState = rememberLazyListState()
    LazyRow(state=listState, contentPadding = PaddingValues(15.dp, 5.dp)){
        items(list) {
            SuggestionChip(
                enabled = true,
                colors = ChipColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    labelColor = MaterialTheme.colorScheme.onPrimary,
                    leadingIconContentColor = MaterialTheme.colorScheme.primary,
                    trailingIconContentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                    disabledLabelColor = MaterialTheme.colorScheme.primary,
                    disabledLeadingIconContentColor = MaterialTheme.colorScheme.background,
                    disabledTrailingIconContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                shape = RoundedCornerShape(50),
                onClick = { Log.d("Suggestion chip", it) },
                label = { Text(it) },
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}