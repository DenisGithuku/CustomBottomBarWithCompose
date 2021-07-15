package com.denisgithuku.jetstate.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomBar(
    currentScreenId: String,
    onScreenSelected: (Screen) -> Unit
) {

    val screens = Screen.ScreenList.list

    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth()) {
        screens.forEach { screen ->
            CustomBottomBarItem(screen = screen, isSelected = screen.id == currentScreenId) {
                onScreenSelected(screen)
            }
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomBarItem(
    screen: Screen,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val backgroundColor = if (isSelected) MaterialTheme.colors.primary.copy(alpha = .1f) else Color.Transparent
    val contentColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(modifier = Modifier
        .clip(CircleShape)
        .background(backgroundColor)
        .clickable(onClick = onClick)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(12.dp)) {
            Icon(imageVector = screen.icon, contentDescription = null, tint = contentColor)

            AnimatedVisibility(visible = isSelected) {
                Text(text = screen.label, color = contentColor)
            }

        }
    }
}