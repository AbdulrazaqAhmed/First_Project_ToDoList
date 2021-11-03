package com.example.todolistproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class TaskModel(
    var title: String,
    var description: String,
    var deudate: String,
    var creationDate: String,
    var isDone: Boolean,
    var indecater : String = "",
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0

)
