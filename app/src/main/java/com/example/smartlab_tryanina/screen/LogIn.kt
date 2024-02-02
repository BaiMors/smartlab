package com.example.smartlab_tryanina.screen

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LogIn () {
   /* val message = remember{mutableStateOf("")*/
    Column (
        modifier = Modifier.run {
            fillMaxSize()
                .background(Color.White)
        }
    ) {
        Text(
            text = "✋ Добро пожаловать!",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Войдите, чтобы воспользоваться функциями приложения",
        )
        Text(
            text = "Вход по Email"
        )
        TextField(
            value = "email", onValueChange = {}
        )
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Далее"
            )
        }
        Text(
            text = "Или войдите с помощью"
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Войти с Яндекс")
        }
    }
}