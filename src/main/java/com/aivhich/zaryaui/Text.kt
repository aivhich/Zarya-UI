package com.aivhich.zaryaui

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp


@Composable
fun MegaText(text: String, textAlign: TextAlign = TextAlign.Center) {
    Text(
        text,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
}

//h1
@Composable
fun HeadlineText(text: String, textAlign: TextAlign = TextAlign.Center) {
    Text(
        text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign
    )
}

//h2
@Composable
fun SubheadingText(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    textColor: Color = Color.Unspecified,
    fontWeight:FontWeight = FontWeight.W500,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        fontSize = 18.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        color = textColor, modifier = modifier
    )
}

//h3
@Composable
fun BodyText(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    weight: FontWeight = FontWeight.Bold,
    color: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        fontSize = TextUnit(14F, TextUnitType.Sp),
        lineHeight = TextUnit(16F, TextUnitType.Sp),
        fontWeight = weight,
        color = color,
        textAlign = textAlign,
        modifier = modifier,
        overflow = TextOverflow.Ellipsis
    )
}

//h4
@Composable
fun SubText(text: String,
            color: Color = Color.Unspecified,
            textAlign: TextAlign = TextAlign.Center,
            overflow: TextOverflow = TextOverflow.Clip,
            fontWeight:FontWeight = FontWeight.Medium,
            lineHeight: TextUnit = 14.sp,
            softWrap:Boolean = false,
            modifier: Modifier = Modifier) {
    Text(
        text,
        color = color,
        fontSize = 12.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        overflow = overflow,
        lineHeight = lineHeight,
        softWrap = softWrap,
        modifier = modifier
    )
}


@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    hyperLinks: Map<String, String>,
    textStyle: TextStyle = TextStyle.Default,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Normal,
    linkTextDecoration: TextDecoration = TextDecoration.None,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    val annotatedString = buildAnnotatedString {
        append(fullText)

        for ((key, value) in hyperLinks) {

            val startIndex = fullText.indexOf(key)
            val endIndex = startIndex + key.length
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = value,
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fullText.length
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = textStyle,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}