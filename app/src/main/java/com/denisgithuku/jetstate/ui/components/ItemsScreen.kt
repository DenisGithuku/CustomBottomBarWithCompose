package com.denisgithuku.jetstate.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.denisgithuku.jetstate.ui.data.Items

@Composable
fun ItemsScreen(
    items: List<Items>
) {
    val state = rememberLazyListState()
    LazyColumn(state = state) {
        items(items = items) { item ->
            Card(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(text = item.title, style = MaterialTheme.typography.body1)
                    Text(text = item.description, style = MaterialTheme.typography.caption)
                }
            }
        }
    }
}