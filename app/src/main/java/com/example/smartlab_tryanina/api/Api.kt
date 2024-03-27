package com.example.smartlab_tryanina.api

import com.example.smartlab_tryanina.models.NewsStruct
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api { //интерфейс - это то, что мы будем делать с заданной апи и какие данные в нее поставлять????????
    //типа здесь мы первоначально объявляем, что у нас в принципе будет какая-то функция на отправку/получение, а вот в Repository она что-то возвращает уже в зависимости от успешности подключения к апи???
    @POST("api/SendCode")
    suspend fun sendCodeEmail(@Header("User-email") email: String):String //мы поставляем в Header User-email в виде строки, и сама suspend функция тоже возвращает строку
    //кстати зачем suspend да.... типа нам нужно будет приостановить отправку кода, если нам Result придет как ошибка?
    //типа запускается в фоне, а не ждется пока выполнится полностью

    @POST("api/SignIn")
    suspend fun checkEmail(@Header("User-email") email: String, @Header("User-code") code: String):String

    @GET("api/News")
    suspend fun GetNews():NewsStruct

    companion object{ //почему компаньен обжект????? он типа не идентифицирует юрл как строку???
        val BASE_URL_SMARTLAB = "https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/" //создаем константу, чтобы было проще вызывать апи по ссылке, хранящейся здесь, в дальнейшем
    }
}