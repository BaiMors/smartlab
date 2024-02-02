package com.example.smartlab_tryanina.screen

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.nio.file.WatchEvent


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LogIn () {
    /* val message = remember{mutableStateOf("") navHost: NavHostController*/
    Column (

        modifier = Modifier.run {
            fillMaxSize()
                .background(Color.White)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "✋ Добро пожаловать!",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 42.dp)
                .padding(end = 32.dp)
                .padding(start = 22.dp),
            //textAlign = Alignment.Start
            //modifier = Modifier.width(414.dp).height(48.dp).align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Войдите, чтобы воспользоваться функциями приложения",
            //textAlign = Alignment.Start,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(end = 22.dp)
                .padding(start = 22.dp)
                .padding(top = 25.dp)
        )
        Text(
            text = "Вход по Email",
            color = Color(0xFF7E7E9A),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(end = 22.dp)
                .padding(start = 22.dp)
                .padding(top = 65.dp)
        )
        TextField(
            value = "email",
            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFF7E7E9A)),

            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(end = 22.dp)
                .padding(start = 22.dp)
                .padding(top = 7.dp),
            onValueChange = {}
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