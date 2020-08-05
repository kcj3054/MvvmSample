package com.example.mvvmsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WriteViewModel : ViewModel() {

    private val writeModel = WriteModel()

    val todo: MutableLiveData<Todo> by lazy {
        MutableLiveData<Todo>()

    }

    val error : MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }

    fun save(content : String?) {

            if (content == null || content.isEmpty()){
            return
        }

        todo.value
        //todo.value todo.livedata를 뽑아온다

        todo.postValue(Todo(0, content, "kcj3054", System.currentTimeMillis()))
        //
    }
}