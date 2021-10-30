package com.example.todolistproject.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistproject.database.TaskModel
import com.example.todolistproject.repository.TaskRepository
import kotlinx.coroutines.launch
import java.sql.Date
import java.sql.Time

class TaskViewModel : ViewModel() {

    private val taskRepository = TaskRepository.get()

    var taskEvent = taskRepository.getTask()

    fun addTask(title: String, description : String, time : Time, date: Date) {
        viewModelScope.launch {
            taskRepository.addTask(TaskModel(title, description, time, date ))
        }

    }
    var selectedItemMutableLiveData = MutableLiveData<TaskModel>()
    fun updateTask(taskModel: TaskModel){

        viewModelScope.launch {
            taskRepository.updateItem(taskModel)
        }
    }

    fun deleteTask(taskModel: TaskModel){
        viewModelScope.launch {
            taskRepository.deleteItem(taskModel)
        }
    }


}