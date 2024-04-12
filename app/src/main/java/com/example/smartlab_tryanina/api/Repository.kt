package com.example.smartlab_tryanina.api

import com.example.smartlab_tryanina.models.NewsPage
import com.example.smartlab_tryanina.models.NewsStruct
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun sendCodeToEmail(email:String):Flow<Result<String>> //функция взаимодействия с апи принимает строковый емаил и в результате многопотокового ее выполнения как результат возвращает строку?????

    suspend fun checkEmail(email: String, code: String):Flow<Result<String>>

    suspend fun getNews():Flow<Result<NewsPage>>

}