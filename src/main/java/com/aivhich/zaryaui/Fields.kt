package com.aivhich.zaryaui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.aivhich.justui.R

@Composable
fun OutlinedField(
    value: String,
    error: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    painter: Painter? = null
) {
    val focusManager = LocalFocusManager.current

    val leadingIcon = @Composable {
        if(painter!=null) {
            Icon(
                painter,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }

    OutlinedTextField(
        value = value,
        isError = error.isNotEmpty(),
        supportingText = null,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = if(painter!=null) leadingIcon else null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { BodyText(placeholder, weight = FontWeight.Normal) },
        label = { BodyText(label, weight = FontWeight.W600) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
    if (error.isNotEmpty()) {
        Spacer(Modifier.height(8.dp))
        SubheadingText(
            text = error,
            modifier = Modifier
                .padding(30.dp, 0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun DigitsField(
    value: String,
    length: Int,
    error: Boolean,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 38.dp,
    boxHeight: Dp = 56.dp,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
) {
    val spaceBetweenBoxes = 8.dp
    BasicTextField(modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Row(
                Modifier.size(width = (boxWidth + spaceBetweenBoxes) * length, height = boxHeight),
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenBoxes),
            ) {
                repeat(length) { index ->
                    Box(
                        modifier = Modifier
                            .size(boxWidth, boxHeight)
                            .border(
                                if (value.getOrNull(index) != null) 2.dp else 1.dp,
                                color = if (!error) {
                                    if (value.getOrNull(index) != null) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.onBackground
                                    }
                                } else {
                                    MaterialTheme.colorScheme.error
                                },
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .then(modifier),
                            text = value.getOrNull(index)?.toString() ?: "",
                            fontSize = TextUnit(28F, TextUnitType.Sp),
                            lineHeight = TextUnit(30F, TextUnitType.Sp),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = if (!error) MaterialTheme.colorScheme.primary else {
                                MaterialTheme.colorScheme.error
                            }
                        )
                    }
                }
            }
        })
}

@Composable
fun NicknameField(
    value: String,
    error: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = stringResource(id = R.string.nickname),
    placeholder: String = stringResource(id = R.string.enter_nickname)
) {

    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            painterResource(id = R.drawable.baseline_alternate_email_24),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }

    OutlinedTextField(
        value = value,
        isError = error.isNotEmpty(),
        supportingText = null,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { BodyText(placeholder, weight = FontWeight.Normal) },
        label = { BodyText(label, weight = FontWeight.W600) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
    if (error.isNotEmpty()) {
        Spacer(Modifier.height(8.dp))
        SubText(
            text = error,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun LoginField(
    value: String,
    error: String = "",
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(0.8f),
    label: String = stringResource(id = R.string.email),
    placeholder: String = stringResource(id = R.string.enter_email)
) {

    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Email,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }

    OutlinedTextField(
        value = value,
        isError = error.isNotEmpty(),
        supportingText = null,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { BodyText(placeholder, weight = FontWeight.Normal) },
        label = { BodyText(label, weight = FontWeight.W600) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
    if (error.isNotEmpty()) {
        Spacer(Modifier.height(8.dp))
        SubText(
            text = error,
            textAlign = TextAlign.Start
        )
    }
}


@Composable
fun PasswordField(
    value: String,
    error: String = "",
    onChange: (String) -> Unit,
    submit: () -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(0.8f),
    label: String = stringResource(id = R.string.password),
    placeholder: String = stringResource(id = R.string.enter_password)
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    val leadingIcon = @Composable {
        Icon(
            painterResource(R.drawable.baseline_key_24),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) painterResource(R.drawable.baseline_visibility_24) else painterResource(
                    R.drawable.baseline_visibility_off_24
                ),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }


    OutlinedTextField(
        value = value,
        isError = error.isNotEmpty(),
        supportingText = null,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { submit() }
        ),
        placeholder = { BodyText(placeholder, weight = FontWeight.Normal) },
        label = { BodyText(label, weight = FontWeight.W600) },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
    if (error.isNotEmpty()) {
        Spacer(Modifier.height(8.dp))
        SubText(
            text = error,
            textAlign = TextAlign.Start
        )
    }
}