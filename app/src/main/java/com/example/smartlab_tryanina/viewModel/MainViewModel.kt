package com.example.smartlab_tryanina.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlab_tryanina.api.Repository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow() //получаем как поток значение того, успешно ли подключилось/отправило/получило данные??? зачем....


    fun sendCodeToEmail2(email:String) //зачем нам второй код на емаил??????
    {
        viewModelScope.launch {
            repository.sendCodeToEmail(email).collect{
                when(it) {
                    /** Instanceof (is) - это оператор на языке java, здесь, в Kotlin, мы использовали is и !
                    это ключевые слова для выполнения операций, таких как instanceof,
                    то есть тип свойства доступен или нет, это функция, подобная способу проверки типа,
                    для проверки типа конкретного экземпляра или других различных переменных во время выполнения,
                    для разделения рабочего процесса.*/
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
}