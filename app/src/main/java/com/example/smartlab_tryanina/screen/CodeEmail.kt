package com.example.smartlab_tryanina.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeEmail(navHost: NavHostController) {
    val num1 = remember{ mutableStateOf("") }
    val num2 = remember{mutableStateOf("")}
    val num3 = remember{mutableStateOf("")}
    val num4 = remember{mutableStateOf("")}
    Column (

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
                .clickable { navHost.navigate("LogInScreen") },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "ArrowBack Icon",
                tint = Color(0xFF7E7E9A),
            )
        }

        Column (

            modifier = Modifier
                .padding(top = 170.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Введите код из E-mail",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = num1.value,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF5F5F9),
                        focusedIndicatorColor = Color(0xEBEBEB),
                        unfocusedIndicatorColor = Color(0xEBEBEB),
                        unfocusedTextColor = Color(0xFF7E7E9A)
                    ),
                    shape = RoundedCornerShape(10.dp),

                    modifier = Modifier
                        .border(width = 1.dp, color = Color(0xFFEBEBEB), shape = RoundedCornerShape(10.dp))
                        .background(Color(0xFFF5F5F9))
                        .height(48.dp)
                        .width(48.dp),

                    singleLine = true,


                    onValueChange = {newnum1 -> num1.value = newnum1}
                )
            }
        }

    }
}