package com.mshdabiola.designsystem.theme.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

@Composable
actual fun fontResources(
    font: String,
    weight: FontWeight,
    style: FontStyle
)=  Font("font/$font", weight, style)