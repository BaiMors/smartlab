package com.example.smartlab_tryanina.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun LogIn (navHost: NavHostController) {
    val email = remember{mutableStateOf("example@mail.com")}
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
            value = email.value,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF5F5F9),
                focusedIndicatorColor = Color(0xEBEBEB),
                unfocusedIndicatorColor = Color(0xEBEBEB),
                //disabledSupportingTextColor = Color(0xFF7E7E9A),
                unfocusedTextColor = Color(0xFF7E7E9A)
            ),
            shape = RoundedCornerShape(10.dp),

            //placeholder = "example@mail.com",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(end = 22.dp)
                .padding(start = 22.dp)
                .padding(top = 7.dp)
                .height(52.dp)
                .clickable { email.value = "" },
            onValueChange = {newEmail -> email.value = newEmail}
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC9D4FB))
        ) {
            Text(
                text = "Далее",
                fontSize = 17.sp
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Или войдите с помощью",

                )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    //.offset(x = 30.dp, y = 50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,


                ),

            ) {
                Text(text = "Войти с Яндекс", color = Color.Black)
            }
        }

    }
}