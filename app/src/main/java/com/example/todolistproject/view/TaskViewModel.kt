package com.example.todolistproject.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistproject.database.TaskModel
import com.example.todolistproject.repository.TaskRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class TaskViewModel : ViewModel() {

    private val taskRepository = TaskRepository.get()
    var selectedTaskMutableLiveData = MutableLiveData<TaskModel>()

    var taskEvent = taskRepository.getTask()

    fun addTask(title: String, description : String, deudate: String) {

        val dateFormat = SimpleDateFormat("yyyy/MM/dd")
        val currentDate = dateFormat.format(Date())

        viewModelScope.launch {
            taskRepository.addTask(TaskModel(title, description,deudate, currentDate,false))
        }

    }
    fun updateTask(taskModel: TaskModel){

        viewModelScope.launch {
            taskRepository.updateTask(taskModel)
        }
    }


    fun deleteTask(taskModel: TaskModel){
        viewModelScope.launch {
            taskRepository.deleteTask(taskModel)
        }
    }


}