package com.example.smartlab_tryanina.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartlab_tryanina.viewModel.MainViewModel

@Composable
fun CreatePassword(navHost: NavHostController, viewModel: MainViewModel) {
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Box(

            modifier = Modifier
                .offset(x = 25.dp, y = 45.dp)
                .height(33.dp)
                .width(33.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF5F5F9))
                .clickable { navHost.navigate("CreatePerson") },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Пропустить",
                color = Color(0xFF1A6FEE)
            )
        }
    }
}