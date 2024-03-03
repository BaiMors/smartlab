package com.example.smartlab_tryanina.api

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun sendCodeToEmail(email:String):Flow<Result<String>> //функция взаимодействия с апи принимает строковый емаил и в результате многопотокового ее выполнения как результат возвращает строку?????


}