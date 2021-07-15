package com.denisgithuku.jetstate.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.denisgithuku.jetstate.ui.components.ItemsScreen
import com.denisgithuku.jetstate.ui.components.ItemsViewModel
import com.denisgithuku.jetstate.ui.data.Items

class MainActivity : ComponentActivity() {

    private val itemsViewModel by viewModels<ItemsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemsActivityScreen(itemsViewModel)
        }
    }
}

@Composable
private fun ItemsActivityScreen(itemsViewModel: ItemsViewModel) {

    val items: List<Items> by itemsViewModel.items.observeAsState(listOf())
    val scaffoldState = rememberScaffoldState()
    val currentScreen = remember {
        mutableStateOf<Screen>(Screen.Home)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopBar()
        },
        bottomBar = {
            CustomBottomBar(currentScreenId = currentScreen.value.id) { screen ->
                currentScreen.value = screen
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            ItemsScreen(items = items)
        }
    }
}


