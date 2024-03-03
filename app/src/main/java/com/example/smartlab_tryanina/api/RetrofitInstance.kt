package com.example.smartlab_tryanina.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance { //я так понимаю, здесь мы настраиваем подключение по http нашего проекта к апи??????
    //плюс добавляем возможность отслеживания за результатами подключения (как через логкэт или это и есть она???????)??????????
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        // Подключаем перехватчик к веб-клиенту. Добавляйте его после других перехватчиков,
        // чтобы ловить все сообщения. Существует несколько уровней перехвата данных: NONE, BASIC, HEADERS, BODY.
        // Последний вариант самый информативный, пользуйтесь им осторожно.
        // При больших потоках данных информация забьёт весь экран. Используйте промежуточные варианты.
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

