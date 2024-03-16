package com.example.smartlab_tryanina.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance { //я так понимаю, здесь мы настраиваем подключение по http нашего проекта к апи
    //добавляем возможность отслеживания за результатами подключения (как через логкэт или это и есть она???????)??????????
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {

        level = HttpLoggingInterceptor.Level.HEADERS //задание уровня, на котором будет выводиться информация об ошибке/результате, типа headers это достаточная информация, которой не слишком много
    }

    private val client: OkHttpClient = OkHttpClient.Builder() //сначала выше мы описали как будем перехватывать ошибки/результаты, потом здесь создали http-клиента, который будет этим способом это делать
        .addInterceptor(interceptor)
        .build()

    //а почему эта переменная от апи наследуется...
    val apiSmartLab: Api = Retrofit.Builder() //это я так понимаю просто то, как работает библиотека retrofit? что нужно там добавить преобразование json, добавить url апи, http клиента,
        .addConverterFactory(GsonConverterFactory.create())//который будет к нему/ней подключаться, ну и построить, чтобы потом через него (ну и через объект подключения) вызывать функции, нужные нам для получения/отпраки определенных данных
        .baseUrl(Api.BASE_URL_SMARTLAB)
        .client(client)
        .build()
        .create(Api::class.java) //что значит запись в скобках...
    //интерфейс преобразовываем в класс, чтобы потом обращаться к его методам через точку
}

