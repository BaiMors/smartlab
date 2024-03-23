package com.example.smartlab_tryanina.api

import android.os.Build
import androidx.annotation.RequiresExtension
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RepositoryImpl(
    private val api: Api //Переменная, наследуемая от интерфейса Api. параметр, в который мы принимаем готовое подключение к апи через объект
) : Repository {
    //переопределяем наследованную функцию из интерфейса репозиторий и добавляем обработку ошибок
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7) //аннотация для перехвата ошибок. нужна для обеспечения с более старыми версиями
    override suspend fun sendCodeToEmail(email:String):Flow<Result<String>>{ //в угловых скобках тип данных (тип данных результата для/из Result.kt?)
        return flow {
            val request = try {
                api.sendCodeEmail(email) //вызываем функцию на отправку из интерфейса Api
            }
            catch (e: IOException) { //улавливает разного рода ошибки? это типа самые распространенные или могут быть еще и их нужно откуда-то узнать...
                e.printStackTrace() //как в шарпе распечатка места ошибки и типа информации о ней
                emit(Result.Error(message = "Don't send code")) //так что все таки за emit, типа он приостанавливает выполнение функции отправки кода???
                return@flow //понятно, что flow - это поток, но поток чего.... и в try мы ничего не возвращаем и он не ругается, это потому что там вызывается функция и это она что-то возвращает?
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code")) //собирает все данные с потока
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code"))
                return@flow
            }
            emit(Result.Success(request)) //типа если все хорошо и мы не поймали ни одного исключения, то результат выполнения функции из try мы отсылаем в класс success из Result.kt и функция отправки кода продолжает выполнение
        }
    }

    override suspend fun checkEmail(email: String, code: String): Flow<Result<String>>{
        return flow {
            val request = try {
                api.checkEmail(email, code)
            }
            catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't find email"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't find email")) //собирает все данные с потока
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't find email"))

                return@flow
            }
            emit(Result.Success(request)) //типа если все хорошо и мы не поймали ни одного исключения, то результат выполнения функции из try мы отсылаем в класс success из Result.kt и функция отправки кода продолжает выполнение
        }
    }
}

//в интерфейсах объявляются методы для чего-либо, а реализуются (типа вызываются?) здесь (типа в try-е ок да)
//почему здесь код для емаил обрабатывает одни ошибочки, а второй код для емаил (из мэин вью модел) вторые ошибочки....
//почему вообще функция возвращает поток...