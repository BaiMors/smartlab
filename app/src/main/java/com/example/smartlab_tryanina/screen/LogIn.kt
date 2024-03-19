package com.example.smartlab_tryanina.screen

//fonts
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab_tryanina.viewModel.MainViewModel


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn (navHost: NavHostController, viewModel: MainViewModel): String {
    val email = remember{mutableStateOf("")}
    var enabled = remember{mutableStateOf(false)}
    val mContext = LocalContext.current
    val response = remember{mutableStateOf("")}

    Column (

        modifier = Modifier.run {
            fillMaxSize()
                .background(Color.White)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            //fontFamily = GoogleFont("SF Pro Display"),
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
        Column ()
        {
        TextField(
            value = email.value,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF5F5F9),
                focusedIndicatorColor = Color(0xEBEBEB),
                unfocusedIndicatorColor = Color(0xEBEBEB),
                unfocusedTextColor = Color(0xFF7E7E9A)
            ),
            shape = RoundedCornerShape(10.dp),

            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(end = 22.dp)
                .padding(start = 22.dp)
                .padding(top = 7.dp)
                .height(52.dp)
                .border(width = 1.dp, color = Color(0xFFEBEBEB), shape = RoundedCornerShape(10.dp))
                .clickable { },

            singleLine = true,

            placeholder = { Text(text = "example@mail.com") },
            onValueChange = {newEmail -> email.value = newEmail}
        )
            enabled.value = email.value.isNotEmpty()
           var color = if(enabled.value) ButtonDefaults.buttonColors(Color(0xFF1A6FEE))
            else ButtonDefaults.buttonColors(Color(0xFFC9D4FB))


        Button(
            onClick = {
                navHost.navigate("CodeEmail")
                viewModel.sendCodeToEmail2(email.value)
                      },
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = color

          ) {
            Text(
                text = "Далее",
                fontSize = 17.sp
            ) }
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
                fontSize = 15.sp,
                color = Color(0xFF939396),
                modifier = Modifier.padding(bottom = 15.dp)
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 45.dp, start = 22.dp, end = 22.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 1.dp, color = Color(0xFFEBEBEB)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White),


                ) {
                Text(
                    text = "Войти с Яндекс",
                    color = Color(0xFF000000),
                    fontSize = 17.sp

                )
            }
        }

    }

    return email.value
}
