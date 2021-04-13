package com.iramarfalcao.todo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iramarfalcao.todo.model.TaskList

class HomeViewModel : ViewModel() {

    private val _taskList = MutableLiveData<TaskList>().apply {
        mutableListOf(
            TaskList("sdas", "asdasd", "#E91E63"),
            TaskList("sdas", "asdasd", "#FFC107"),
            TaskList("sdas", "asdasd", "#2196F3"),
            TaskList("sdas", "asdasd", "#4CAF50"),
            TaskList("sdas", "asdasd", "#F44336"),
            TaskList("sdas", "asdasd", "#FF7043"),
            TaskList("sdas", "asdasd", "#E91E63"),
            TaskList("sdas", "asdasd", "#FFC107"),
            TaskList("sdas", "asdasd", "#2196F3"),
            TaskList("sdas", "asdasd", "#4CAF50"),
            TaskList("sdas", "asdasd", "#F44336"),
            TaskList("sdas", "asdasd", "#FF7043"),
        )
    }

    val taskList: LiveData<TaskList> = _taskList
}