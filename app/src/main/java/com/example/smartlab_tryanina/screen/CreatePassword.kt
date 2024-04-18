package com.example.smartlab_tryanina.screen

/*import androidx.compose.foundation.layout.FlowColumnScopeInstance.align*/
import android.R.attr.text
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab_tryanina.viewModel.MainViewModel

var num = ""

var bord1 = 1
var bord2 = 1
var bord3 = 1
var bord4 = 1
/*@Preview*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePassword(navHost: NavHostController, viewModel: MainViewModel) {

    var pad = 10
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .offset(x = 280.dp, y = 25.dp)
                .height(50.dp)
                .width(90.dp)
                .clip(RoundedCornerShape(10.dp))
                /*.background(Color(0xFFF5F5F9))*/
                .clickable { navHost.navigate("CreatePerson") },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Пропустить",
                color = Color(0xFF1A6FEE),
                fontSize = 15.sp
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Text(
                //fontFamily = GoogleFont("SF Pro Display"),
                text = "Создайте пароль",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    /*.fillMaxWidth()*/
                    .padding(top = 42.dp)
                    .padding(end = 32.dp)
                    .padding(start = 22.dp)
                    .align(Alignment.CenterHorizontally),
                //textAlign = Alignment.Start
                //modifier = Modifier.width(414.dp).height(48.dp).align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Для защиты ваших персональных данных",
                color = Color(0xFF939396),
                //textAlign = Alignment.Start,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 22.dp)
                    .padding(start = 22.dp)
                    .padding(top = 15.dp)
            )



            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp)
            ) {
                TextField(
                    value = "",
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFFFFFFF),
                        focusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedTextColor = Color(0xFFFFFFFF)
                    ),

                    modifier = Modifier
                        .padding(pad.dp)
                        .height(16.dp)
                        .width(16.dp)
                        .border(bord1.dp, Color(0xFF1A6FEE), shape = CircleShape),

                    onValueChange = {}
                )
                TextField(
                    value = "",
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFFFFFFF),
                        focusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedTextColor = Color(0xFFFFFFFF)
                    ),

                    modifier = Modifier
                        .padding(pad.dp)
                        .height(16.dp)
                        .width(16.dp)
                        .border(bord2.dp, Color(0xFF1A6FEE), shape = CircleShape),

                    onValueChange = {}
                )
                TextField(
                    value = "",
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFFFFFFF),
                        focusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedTextColor = Color(0xFFFFFFFF)
                    ),

                    modifier = Modifier
                        .padding(pad.dp)
                        .height(16.dp)
                        .width(16.dp)
                        .border(bord3.dp, Color(0xFF1A6FEE), shape = CircleShape),

                    onValueChange = {}
                )
                TextField(
                    value = "",
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFFFFFFF),
                        focusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedIndicatorColor = Color(0xFFFFFFFF),
                        unfocusedTextColor = Color(0xFFFFFFFF)
                    ),

                    modifier = Modifier
                        .padding(pad.dp)
                        .height(16.dp)
                        .width(16.dp)
                        .border(bord4.dp, Color(0xFF1A6FEE), shape = CircleShape),

                    onValueChange = {}
                )
/*                Box (
                    Modifier
                        .border(1.dp, Color(0xFF1A6FEE), shape = CircleShape)
                        .width(16.dp)
                        .height(16.dp)
                        
                ) {}
                Box (
                    Modifier
                        .border(1.dp, Color(0xFF1A6FEE), shape = CircleShape)
                        .width(16.dp)
                        .height(16.dp)
                ) {}
                Box (
                    Modifier
                        .border(1.dp, Color(0xFF1A6FEE), shape = CircleShape)
                        .width(16.dp)
                        .height(16.dp)
                ) {}*/
            }


            var _tcolor = Color(0xFF000000)
            var __tcolor = Color(0xFFFFFFFF)
            var _color = ButtonDefaults.buttonColors(Color(0xFFF5F5F9))
            var __color = ButtonDefaults.buttonColors(Color(0xFF1A6FEE))

            val c = listOf(1, 4, 7)
            for (i in c) {
                var isPressed by remember { mutableStateOf(false) }
                var isPressed1 by remember { mutableStateOf(false) }
                var isPressed2 by remember { mutableStateOf(false) }
                val color = if (isPressed) __color else _color
                val color1 = if (isPressed1) __color else _color
                val color2 = if (isPressed2) __color else _color

                val tcolor = if (isPressed) __tcolor else _tcolor
                val tcolor1 = if (isPressed1) __tcolor else _tcolor
                val tcolor2 = if (isPressed2) __tcolor else _tcolor

                Row (
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 25.dp)
                ) {
                    Box(modifier = Modifier.padding(pad.dp))
                    {
                        Button(

                            onClick = {
                                if (num.length != 4) num += i.toString()
                                isPressed = !isPressed
                            },
                            //interactionSource = interactionSource,
                            colors = color,
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                        ) {
                            Text(
                                text = i.toString(),
                                textAlign = TextAlign.Center,
                                color = tcolor,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                    if (isPressed == true) isPressed = !isPressed
                    else isPressed = isPressed

                    Box(modifier = Modifier.padding(pad.dp))
                    {
                        Button(
                            onClick = {
                                if (num.length != 4) num += (i+1).toString()
                                isPressed1 = !isPressed1
                            },
                            colors = color1,
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)

                        ) {
                            Text(
                                text = (i+1).toString(),
                                textAlign = TextAlign.Center,
                                color = tcolor1,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                    if (isPressed1 == true) isPressed1 = !isPressed1
                    else isPressed1 = isPressed1

                    Box(modifier = Modifier.padding(pad.dp))
                    {
                        Button(
                            onClick = {
                                if (num.length != 4) num += (i+2).toString()
                                isPressed2 = !isPressed2
                            },

                            colors = color2,
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)

                        ) {
                            Text(
                                text = (i+2).toString(),
                                textAlign = TextAlign.Center,
                                color = tcolor2,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                    if (isPressed2 == true) isPressed2 = !isPressed2
                    else isPressed2 = isPressed2
                }

            }


            var forNol = listOf(0)
            for (i in forNol)
            {
                var isPressed0 by remember { mutableStateOf(false) }
                val color0 = if (isPressed0) __color else _color
                val tcolor0 = if (isPressed0) __tcolor else _tcolor
                Row (
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 25.dp)
                ) {
                    Box(modifier = Modifier.padding(pad.dp))
                    {
                        Button(
                            onClick = {
                                if (num.length != 4) num += i.toString()
                                isPressed0 = !isPressed0
                            },
                            colors = color0,
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)

                        ) {
                            Text(
                                text = i.toString(),
                                textAlign = TextAlign.Center,
                                color = tcolor0,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
//
                }
                if (isPressed0 == true) isPressed0 = !isPressed0
                else isPressed0 = isPressed0
            }

        }
        if (num.length >= 1) bord1 = 10
        else if (num.length >= 2) bord2 = 10
        else if (num.length >= 3) bord3 = 10
        else if (num.length == 4)
        {
            bord4 = 10
            navHost.navigate("CreatePerson")
        }

    }
}

/*


            var en = remember{ mutableStateOf(false) }
            val interactionSource = remember { MutableInteractionSource() }
            val pressed by interactionSource.collectIsPressedAsState()
            var col by remember { mutableStateOf(Color(0xFF1A6FEE)) }
            if (pressed) {
                color = ButtonDefaults.buttonColors(Color(0xFF1A6FEE))
                tcolor = Color(0xFFFFFFFF)
            }
            else {
                color = ButtonDefaults.buttonColors(Color(0xFFF5F5F9))
                tcolor = Color(0xFF000000)
            }



Row (
    modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = 25.dp)
) {
    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 4.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        ) {
            Text(
                text = "4",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 5.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)

        ) {
            Text(
                text = "5",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 6.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)

        ) {
            Text(
                text = "6",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

}

Row (
    modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = 25.dp)
) {
    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 7.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        ) {
            Text(
                text = "7",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 8.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)

        ) {
            Text(
                text = "8",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    Box(modifier = Modifier.padding(pad.dp))
    {
        Button(
            onClick = {
                num += 9.toString()
            },
            colors = color,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)

        ) {
            Text(
                text = "9",
                textAlign = TextAlign.Center,
                color = tcolor,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

}*/
