package com.aivhich.zaryaui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aivhich.zaryaui.models.CarouselIconItem


@Composable
fun FieldBoxWithText(
    label: String, text: String,
    modifier: Modifier = Modifier
        .padding(15.dp, 2.dp, 15.dp, 2.dp)
        .height(64.dp)
) {
    Column(
        Modifier.then(modifier),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        SubText(
            text = label,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
        )
        Spacer(Modifier.height(6.dp))
        BodyText(text = text)
    }
}

@Composable
fun CarouselWithIconText(
    items: List<CarouselIconItem>,
    modifier: Modifier = Modifier
        .height(96.dp)
        .width(64.dp)
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(items) {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.then(modifier)
            ) {
                Icon(
                    painter = it.painter,
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.tertiary)
                        .padding(8.dp),
                    contentDescription = it.text
                )
                SubText(
                    text = it.text,
                    lineHeight = 14.sp,
                    softWrap = true
                )
            }
            Spacer(Modifier.width(6.dp))
        }
    }
}

@Composable
fun PointsPanel(text: String, painter: Painter, bigtype: Boolean = false) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        if (!bigtype) {
            BodyText(text = text,
                weight = FontWeight.SemiBold)
        } else {
            SubheadingText(text = text)
        }
        Icon(painter, "")
    }
}


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
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(5.dp, 5.dp)
            )
        }
        Column(
            Modifier
                .shadow(1.6.dp, RoundedCornerShape(20.dp))
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