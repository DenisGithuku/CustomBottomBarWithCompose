package com.denisgithuku.jetstate.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val label: String,
    val id: String,
    val icon: ImageVector
) {
    object Home: Screen("Home", "home", Icons.Outlined.Home)
    object Settings: Screen("Settings", "settings", Icons.Outlined.Settings)
    object Favorite: Screen("Profile", "profile", Icons.Outlined.Person)
    object Discover: Screen("Discover", "discover", Icons.Outlined.Search)

    object ScreenList {
        val list = listOf(
            Home, Settings, Favorite, Discover
        )
    }
}
