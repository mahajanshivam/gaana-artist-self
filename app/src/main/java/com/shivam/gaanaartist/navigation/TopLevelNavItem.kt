package com.shivam.gaanaartist.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.shivam.gaanaartist.feature.audience.api.navigation.AudienceNavKey
import com.shivam.gaanaartist.feature.canvas.api.navigation.CanvasNavKey
import com.shivam.gaanaartist.feature.home.api.navigation.HomeNavKey
import com.shivam.gaanaartist.feature.music.api.navigation.MusicNavKey
import com.shivam.gaanaartist.feature.profile.api.navigation.ProfileNavKey
import com.shivam.gaanaartist.feature.audience.api.R as audienceR
import com.shivam.gaanaartist.feature.canvas.api.R as canvasR
import com.shivam.gaanaartist.feature.home.api.R as homeR
import com.shivam.gaanaartist.feature.music.api.R as musicR
import com.shivam.gaanaartist.feature.profile.api.R as profileR

/**
 * Type for the top level navigation items in the application. Contains UI information about the
 * current route that is used in the top app bar and common navigation UI.
 *
 * @param selectedIcon The icon to be displayed in the navigation UI when this destination is
 * selected.
 * @param unselectedIcon The icon to be displayed in the navigation UI when this destination is
 * not selected.
 * @param iconTextId Text that to be displayed in the navigation UI.
 * @param titleTextId Text that is displayed on the top app bar.
 */


data class TopLevelNavItem(
    @DrawableRes val navIcon: Int,
    @StringRes val navTitle: Int,

//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    @StringRes val iconTextId: Int,
//    @StringRes val titleTextId: Int,
)

val HOME = TopLevelNavItem(
    navIcon = homeR.drawable.feature_home_api_ic_home_nav,
    navTitle = homeR.string.feature_home_api_nav_title,
//    selectedIcon = NiaIcons.Upcoming,
//    unselectedIcon = NiaIcons.UpcomingBorder,
)

val MUSIC = TopLevelNavItem(
    navIcon = musicR.drawable.feature_music_api_ic_music_nav,
    navTitle = musicR.string.feature_music_api_nav_title,
//    titleTnavTitleextId = musicR.string.feature_music_api_nav_title,
//    selectedIcon = NiaIcons.Bookmarks,
//    unselectedIcon = NiaIcons.BookmarksBorder,
)

val AUDIENCE = TopLevelNavItem(
    navIcon = audienceR.drawable.feature_audience_api_ic_audience_nav,
    navTitle = audienceR.string.feature_audience_api_nav_title,
//    titleTextId = audienceR.string.feature_audience_api_nav_title,
//    selectedIcon = NiaIcons.Bookmarks,
//    unselectedIcon = NiaIcons.BookmarksBorder,
)

val CANVAS = TopLevelNavItem(
    navIcon = canvasR.drawable.feature_canvas_api_ic_canvas_nav,
    navTitle = canvasR.string.feature_canvas_api_nav_title,
//    titleTextId = canvasR.string.feature_canvas_api_nav_title,
//    selectedIcon = NiaIcons.Bookmarks,
//    unselectedIcon = NiaIcons.BookmarksBorder,
)

val PROFILE = TopLevelNavItem(
    navIcon = profileR.drawable.feature_profile_api_ic_profile_nav,
    navTitle = profileR.string.feature_profile_api_nav_title,
//    titleTextId = profileR.string.feature_profile_api_nav_title,
//    selectedIcon = NiaIcons.Bookmarks,
//    unselectedIcon = NiaIcons.BookmarksBorder,
)

val TOP_LEVEL_NAV_ITEMS = mapOf(
    HomeNavKey to HOME,
    MusicNavKey to MUSIC,
    AudienceNavKey to AUDIENCE,
    CanvasNavKey to CANVAS,
    ProfileNavKey to PROFILE
)
