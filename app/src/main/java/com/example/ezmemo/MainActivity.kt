package com.example.ezmemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ezmemo.composables.ItemListScreen
import com.example.ezmemo.composables.TimerScreen
import com.example.ezmemo.composables.TimerScreenContent
import com.example.ezmemo.repositorys.ItemRepository
import com.example.ezmemo.room.ItemDao
import com.example.ezmemo.ui.theme.EzmemoTheme
import com.example.ezmemo.viewmodel.ItemViewModel
import com.example.ezmemo.viewmodel.TimerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EzmemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    val itemViewModel: ItemViewModel = viewModel()
                    val timerViewModel : TimerViewModel = viewModel()
                    TimerScreenContent(timerViewModel)
                }
            }
        }
    }
}