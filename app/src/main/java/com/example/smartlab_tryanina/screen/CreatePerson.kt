package com.example.smartlab_tryanina.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.smartlab_tryanina.viewModel.MainViewModel

@Composable
fun CreatePerson(navHost: NavHostController, viewModel: MainViewModel) {
    Text(
        text = "create person",
        color = Color(0xFF1A6FEE)
    )
}