package com.example.todolistproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*


@Entity
data class TaskModel(
    val title : String,
    val description : String,
    val time : Time,
    val date: Date,
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0



)
