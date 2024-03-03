package com.example.smartlab_tryanina.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartlab_tryanina.api.Repository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/** ViewModel - один из наиболее важных классов компонентов архитектуры Android Jetpack,
поддерживающих данные для компонентов пользовательского интерфейса.
Его назначение - хранить данные, связанные с пользовательским интерфейсом, и управлять ими.
Более того, его основная функция заключается в поддержании целостности и позволяет обслуживать данные во время изменений
конфигурации, таких как поворот экрана.
Любое изменение конфигурации на устройствах Android приводит к воссозданию всей активности приложения.*/
class MainViewModel(private val repository: Repository): ViewModel() {
    /** Каналы (Channel) позволяют передавать потоки данных*/
    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()


    fun sendCodeToEmail2(email:String)
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