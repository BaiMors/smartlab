package com.example.smartlab_tryanina.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlab_tryanina.api.Repository
import com.example.smartlab_tryanina.models.ResultNews
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() { //RepositoryImpl возвращает поток (какой бы то ни было?) и что мы с ним дальше делаем...

    private val _toGetNews = MutableStateFlow<List<ResultNews>>(emptyList())

    /**
    StateFlow в Kotlin ведёт себя так же, как LiveData, за исключением того,
    что LiveData имеет осведомлённость о жизненном цикле и не требует начального значения.
     *
    Чтобы создать поток StateFlow, нужно создать экземпляр MutableStateFlow с обязательным начальным значением.
    Затем вызвать asStateFlow() на этом экземпляре, чтобы преобразовать его в StateFlow,
    из которого можно собирать изменения состояния.*/
    val toGetNews = _toGetNews.asStateFlow()

    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel =
        _showErrorToastChannel.receiveAsFlow() //получаем как поток значение того, успешно ли подключилось/отправило/получило данные??? зачем....

    //подписываемся на поток. что-то в нем поменялось, то отсылаем это в переменную

    //
    fun sendCodeToEmail2(email: String) //зачем нам второй код на емаил?????? типа один сетевой а другой на клиенте или как....
    {
        viewModelScope.launch {//запускаем поток, в котором потом вызываем поточную функцию из Repository
            //emit ранее собрал/обернул данные в коллекцию, которую мы здесь разворачиваем
            repository.sendCodeToEmail(email).collect {
                when (it) { //то, что мы вывернули из emit-а, ответ сервера
                    /**//**//**/
                    /** Instanceof (is) - это оператор на языке java, здесь, в Kotlin, мы использовали is и !
                    это ключевые слова для выполнения операций, таких как instanceof,
                    то есть тип свойства доступен или нет, это функция, подобная способу проверки типа,
                    для проверки типа конкретного экземпляра или других различных переменных во время выполнения,
                    для разделения рабочего процесса.*/
                    is com.example.smartlab_tryanina.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }

                    is com.example.smartlab_tryanina.api.Result.Success -> {
                        _showErrorToastChannel.send(false) //вообще типа если все хорошо то мы переходим на следующий экран и просто продолжаем
                    }
                }
            }
        }
    }

    fun checkEmail2(email: String, code: String) {
        viewModelScope.launch {

            repository.checkEmail(email, code).collect {
                when (it) {

                    is com.example.smartlab_tryanina.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }

                    is com.example.smartlab_tryanina.api.Result.Success -> {
                        _showErrorToastChannel.send(false)
                    }
                }
            }
        }
    }

    fun getNews2() {
        viewModelScope.launch {

            repository.getNews().collect { result ->
                when (result) {

                    is com.example.smartlab_tryanina.api.Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }

                    is com.example.smartlab_tryanina.api.Result.Success -> {
                        result.data?.let { New ->
                            _toGetNews.update { New.results }
                        }
                    }
                }
            }
        }
    }
}