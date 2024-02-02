package com.example.smartlab_tryanina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.Navigation
import com.example.smartlab_tryanina.screen.LogIn
//import com.example.smartlab_tryanina.screen.SplashScreen
/*Класс для перемещения по страницам*/
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,//контроллер реагирующий и отвечающий за перемещения
        startDestination = "logInScreen")
    {
        //Для каждой страницы задается route - для дальнейшего обращения к ней
        //и указывается метод для запуска с переданными параметрами
//        composable("splashScreen"){
//            SplashScreen(navController)
//        }
        composable("logInScreen"){
            LogIn()
        }
    }
}