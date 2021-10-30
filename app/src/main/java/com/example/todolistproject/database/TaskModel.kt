package com.example.todolistproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class TaskModel(
    val tital : String,
    val description : String,
    val time : Int,
    val date: Int,
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0



)
