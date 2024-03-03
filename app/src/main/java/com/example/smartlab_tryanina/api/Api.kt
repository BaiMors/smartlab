package com.example.smartlab_tryanina.api

import retrofit2.http.Header
import retrofit2.http.POST

interface Api { //интерфейс - это то, что мы будем делать с заданной апи и какие данные в нее поставлять????????
    @POST("api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String //мы поставляем в Header User-email в виде строки, и сама suspend функция тоже возвращает строку?????
    companion object{ //почему компаньен обжект????? он типа не идентифицирует юрл как строку???
        val BASE_URL_SMARTLAB = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/" //создаем константу, чтобы было проще вызывать апи по ссылке, хранящейся здесь, в дальнейшем
    }
}