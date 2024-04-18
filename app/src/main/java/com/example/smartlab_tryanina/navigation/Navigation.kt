package com.example.smartlab_tryanina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab_tryanina.screen.AnalysysMain
import com.example.smartlab_tryanina.screen.CodeEmail
import com.example.smartlab_tryanina.screen.CreatePassword
import com.example.smartlab_tryanina.screen.LogIn
import com.example.smartlab_tryanina.viewModel.MainViewModel

/*Класс для перемещения по страницам*/
@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController,//контроллер реагирующий и отвечающий за перемещения
        startDestination = "logInScreen")
    {
        composable("logInScreen"){
            LogIn(navController, viewModel)
        }
        composable("CodeEmail"){
            CodeEmail(navController, viewModel)
        }
        composable("CreatePassword"){
            CreatePassword(navController, viewModel)
        }
        composable("CreatePerson"){
            AnalysysMain(navController, viewModel)
        }
    }
}