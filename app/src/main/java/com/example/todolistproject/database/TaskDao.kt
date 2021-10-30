package com.example.todolistproject.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

        @Insert
        suspend fun addTask(taskModel : TaskModel)


        @Query("SELECT * FROM TaskModel")
        fun getTask() : LiveData<List<TaskModel>>

        @Update
        suspend fun updateTask(taskModel : TaskModel)


        @Delete

        suspend fun deleteTask(taskModel: TaskModel)
}