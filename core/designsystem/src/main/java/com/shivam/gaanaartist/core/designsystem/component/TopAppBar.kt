package com.shivam.gaanaartist.core.designsystem.component


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shivam.gaanaartist.core.designsystem.theme.GaanaArtistSelfTheme
import com.shivam.gaanaartist.core.designsystem.R as designSysR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaanaArtistTopAppBar(
    @StringRes titleRes: Int,
//    navigationIcon: ImageVector,
    @DrawableRes navigationIcon: Int,
    navigationIconContentDescription: String,
//    actionIcon: ImageVector,
    @DrawableRes actionIcon: Int,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    painter = painterResource(navigationIcon),
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = painterResource(navigationIcon),
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("GaanaArtistTopAppBar"),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun GaanaArtistTopAppBarPreview() {
    GaanaArtistSelfTheme {
        GaanaArtistTopAppBar(
            titleRes = android.R.string.untitled,
            navigationIcon = designSysR.drawable.ic_settings_nav,
            navigationIconContentDescription = "Navigation icon",
            actionIcon = designSysR.drawable.ic_settings_nav,
            actionIconContentDescription = "Action icon",
        )
    }
}
