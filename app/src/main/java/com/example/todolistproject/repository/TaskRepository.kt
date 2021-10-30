package com.example.todolistproject.repository

import android.content.Context
import androidx.room.Room
import com.example.todolistproject.database.TaskDatabase
import com.example.todolistproject.database.TaskModel


private const val DATABASE_NAME= "task-database"
class TaskRepository(context: Context) {

    private val database : TaskDatabase = Room.databaseBuilder(
        context,
        TaskDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build() //to allow us make changes on database

    private val taskDao = database.taskDao()

    fun getTask() = taskDao.getTask()

    suspend fun addTask(taskModel: TaskModel) = taskDao.addTask(taskModel)

    suspend fun updateTask(taskModel: TaskModel) = taskDao.updateTask(taskModel)


    suspend fun deleteTask(taskModel: TaskModel) = taskDao.deleteTask(taskModel)

    companion object{
        private var instance : TaskRepository? = null

        fun init(context: Context){
            if (instance == null)
                instance = TaskRepository(context)
        }
        fun get(): TaskRepository{
            return instance ?: throw Exception("Inventory Repository must be initialize")
        }
    }


}