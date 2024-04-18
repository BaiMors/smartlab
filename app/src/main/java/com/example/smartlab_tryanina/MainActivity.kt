package com.example.smartlab_tryanina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartlab_tryanina.api.RepositoryImpl
import com.example.smartlab_tryanina.api.RetrofitInstance
import com.example.smartlab_tryanina.navigation.Navigation
import com.example.smartlab_tryanina.ui.theme.Smartlab_tryaninaTheme
import com.example.smartlab_tryanina.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    //Создание провайдера ViewModel
    //тчо за провайдеры вообще.......... (написала в ретрофит инстанс)
    private val viewModelSmart by viewModels<MainViewModel>(factoryProducer = { //что за продюсер......
        object : ViewModelProvider.Factory { //тут типа тоже надо просто понять и простить что так "надо" писать? как с той фабрикой по конвертации json?
            override fun <T : ViewModel> create(modelClass: Class<T>): T { //как мы переопределяем viewmodel как функцию...
                return MainViewModel(RepositoryImpl(RetrofitInstance.apiSmartLab))
                        as T
            }
        }
    })
    //factoryProducer - определение, что за такое наш провайдер/посредник между сервером и ui. в этом конструкторе есть метод, который мы переопределяем, чтобы он возвращал нашу viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Smartlab_tryaninaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModelSmart)
                }
            }
        }
    }
}
