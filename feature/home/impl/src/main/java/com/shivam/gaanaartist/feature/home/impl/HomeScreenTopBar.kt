package com.shivam.gaanaartist.feature.home.impl

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shivam.gaanaartist.core.designsystem.component.ManropeWhiteText
import com.shivam.gaanaartist.core.model.data.HomeScreenTopBarData
import com.shivam.gaanaartist.core.data.R as dataR
import com.shivam.gaanaartist.core.designsystem.R as desSysR

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    userData: HomeScreenTopBarData
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(40.dp),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(dataR.drawable.sample_image_delete_later),
            contentDescription = "User profile pic"
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .wrapContentHeight()
                .weight(1f)
        ) {
            ManropeWhiteText(
                text = userData.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            ManropeWhiteText(
                text = userData.subText,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
            )
        }

        Icon(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp),
            painter = painterResource(desSysR.drawable.ic_bell_notification),
            contentDescription = "Settings Icon",
            tint = Color.Unspecified
        )

        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(desSysR.drawable.ic_settings_nav),
            contentDescription = "Settings Icon",
            tint = Color.Unspecified
        )

    }
}

@Preview
@Composable
private fun HomeScreenTopBarPreview() {
    HomeScreenTopBar(
        userData = HomeScreenTopBarData(
            name = "Good Morning Ed Sheeran",
            subText = "Mon, Feb 12",
            imageUrl = ""
        )
    )
}