package com.example.smartlab_tryanina.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab_tryanina.viewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeEmail(navHost: NavHostController, viewModel: MainViewModel) {
    val (num1, setn1) = remember { mutableStateOf("") }
    val (num2, setn2) = remember { mutableStateOf("") }
    val (num3, setn3) = remember { mutableStateOf("") }
    val (num4, setn4) = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val maxLength = 1
    val mContext = LocalContext.current
    val focusManager = LocalFocusManager.current

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }

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
                .clickable { navHost.navigate("LogInScreen") },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "ArrowBack Icon",
                tint = Color(0xFF7E7E9A),
            )
        }

        Column(

            modifier = Modifier
                .padding(top = 170.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Введите код из E-mail",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LaunchedEffect(
                    key1 = num1,
                ) {
                    if (num1.isNotEmpty()) {
                        focusManager.moveFocus(
                            focusDirection = FocusDirection.Next,
                        )
                    }
                }
                LaunchedEffect(
                    key1 = num2,
                ) {
                    if (num2.isNotEmpty()) {
                        focusManager.moveFocus(
                            focusDirection = FocusDirection.Next,
                        )
                    }
                }
                LaunchedEffect(
                    key1 = num3,
                ) {
                    if (num3.isNotEmpty()) {
                        focusManager.moveFocus(
                            focusDirection = FocusDirection.Next,
                        )
                    }
                }
                Box(modifier = Modifier.padding(10.dp)) {
                    TextField(
                        value = num1,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F9),
                            focusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedTextColor = Color(0xFF7E7E9A)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEBEB),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(48.dp)
                            .width(48.dp)
                            .focusRequester(focusRequester),
                        singleLine = true,
                        onValueChange = {
                            if (it.length <= maxLength) setn1(it)
                            else Toast.makeText(
                                mContext,
                                "Необходимо ввести 1 цифру",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
                Box(modifier = Modifier.padding(10.dp)) {
                    TextField(
                        value = num2,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F9),
                            focusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedTextColor = Color(0xFF7E7E9A)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEBEB),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(48.dp)
                            .width(48.dp),
                        singleLine = true,
                        onValueChange = {
                            if (it.length <= maxLength) setn2(it)
                            else Toast.makeText(
                                mContext,
                                "Необходимо ввести 1 цифру",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
                Box(modifier = Modifier.padding(10.dp)) {
                    TextField(
                        value = num3,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F9),
                            focusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedTextColor = Color(0xFF7E7E9A)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEBEB),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(48.dp)
                            .width(48.dp),
                        singleLine = true,
                        onValueChange = {
                            if (it.length <= maxLength) setn3(it)
                            else Toast.makeText(
                                mContext,
                                "Необходимо ввести 1 цифру",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
                Box(modifier = Modifier.padding(10.dp)) {
                    TextField(
                        value = num4,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFF5F5F9),
                            focusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedIndicatorColor = Color(0xEBEBEB),
                            unfocusedTextColor = Color(0xFF7E7E9A)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        textStyle = TextStyle(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEBEB),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .height(48.dp)
                            .width(48.dp),
                        singleLine = true,
                        onValueChange = {
                            if (it.length <= maxLength) setn4(it)
                            else Toast.makeText(
                                mContext,
                                "Необходимо ввести 1 цифру",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }

    }

    val str = num1 + num2 + num3 + num4
    if (num4.isNotEmpty()) {
        navHost.navigate("CreatePassword")
    }
}

/*    val str = StringBuilder()
    str.append(num1).append(num2).append(num3).append(num4)
    Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show()*/
//    if(num4.isNotEmpty() and str = ) navHost.navigate("CreatePassword")
