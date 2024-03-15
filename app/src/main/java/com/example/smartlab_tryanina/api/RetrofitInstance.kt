package com.example.smartlab_tryanina.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance { //я так понимаю, здесь мы настраиваем подключение по http нашего проекта к апи??????
    //добавляем возможность отслеживания за результатами подключения (как через логкэт или это и есть она???????)??????????
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {

        level = HttpLoggingInterceptor.Level.HEADERS
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val apiSmartLab: Api = Retrofit.Builder() //а можно узнать что это вообще такое... и то что выше тоже
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Api.BASE_URL_SMARTLAB)
        .client(client)
        .build()
        .create(Api::class.java)
}

//здесь создается объект для подключения к апи, через который потом будет вызываться метод отправки кода на емаил?????