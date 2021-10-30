package com.example.todolistproject.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

        @Insert
        suspend fun addTask(taskModel : TaskModel)


        @Query("SELECT * FROM taskmodel")
        fun getItem() : LiveData<List<TaskModel>>

        @Update
        suspend fun updateItem(itemModel : TaskModel)


        @Delete

        suspend fun deleteItem(itemModel: TaskModel)
}