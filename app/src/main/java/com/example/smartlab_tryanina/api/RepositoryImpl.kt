package com.example.smartlab_tryanina.api

import android.os.Build
import androidx.annotation.RequiresExtension
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RepositoryImpl(
    private val api: Api //Переменная интерфейса Api, зачем бы то ни было?????????
) : Repository {
    //переопределяем функцию из интерфейса репозиторий (зачем бы то ни было) и добавляем обработку ошибок??? видимо. там не написано.
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7) //что вообще эта аннотация значит????
    override suspend fun sendCodeToEmail(email:String):Flow<Result<String>>{ //почему они кстати в угловых скобочках? вроде так у листов в шарпе
        return flow {
            val request = try {
                api.sendCodeEmail(email)
            }
            catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code")) //что такое emit и почему у меня не заходит вывод ошибки
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code"))
                return@flow
            }
            emit(Result.Success(request))
        }
    }
}

//в интерфейсах объявляются методы для чего-либо, а реализуются (типа вызываются?) здесь.
//почему здесь код для емаил обрабатывает одни ошибочки, а второй код для емаил (из мэин вью модел) вторые ошибочки....