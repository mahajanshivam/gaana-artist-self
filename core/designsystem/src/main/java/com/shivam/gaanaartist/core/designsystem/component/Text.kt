package com.shivam.gaanaartist.core.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun ManropeWhiteText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 14.sp,
    color: Color = Color.White,
    letterSpacing: TextUnit = 0.em,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {

    Text(
        modifier = modifier.padding(vertical = 0.dp),
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        maxLines = maxLines,
        overflow = overflow,
//        fontFamily = Manrope  // TODO:: add Manrope font file and then use it here
    )
}

@ThemePreviews
@Composable
private fun ManropeWhiteTextPreview() {
    ManropeWhiteText(text = "This is preview of ManropeText composable")
}