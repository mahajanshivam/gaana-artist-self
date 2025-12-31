package com.shivam.gaanaartist.feature.canvas.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.shivam.gaanaartist.core.navigation.Navigator
import com.shivam.gaanaartist.feature.canvas.api.navigation.CanvasNavKey
import com.shivam.gaanaartist.feature.canvas.impl.CanvasScreen

fun EntryProviderScope<NavKey>.canvasEntry(navigator: Navigator) {

    entry<CanvasNavKey> {
        CanvasScreen(onClick = {})
    }

}