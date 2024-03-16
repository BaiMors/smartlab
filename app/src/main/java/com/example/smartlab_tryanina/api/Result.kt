package com.example.smartlab_tryanina.api

    sealed class Result<T>(
        val data: T? = null,
        val message: String? = null
    ) {
        //почему мы ниже наследуемся от sealed класса, если его идея вроде как в том, что от него нельзя наследоваться... или тут подразумевается класс этот как уникальный тип данных?
        //это классы вложенные, поэтому они могут наследоваться от result-а
        class Success<T>(data: T?) : Result<T>(data) //data это типа вообще любые данные? которые мы посылаем как ?параметр? в класс
        class Error<T>(data: T? = null, message: String?) : Result<T>(data, message) //типа тут мы словили исключение и никакие данные возвращать не нужно, поэтому они зануляются и выводится сообщение?
    }

//обобщенный класс, который приниамет все что угодно, но при обращении к нему нужно указывать, что именно будет приниматься? типа тип данных (c#, здесь так не надо)