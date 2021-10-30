package com.example.todolistproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel
import java.sql.Date
import java.sql.Time

class TaskAdapter (val tasks:List<TaskModel>,val viewModel: TaskViewModel):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.task_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.addTitleeEdittext.text = task.title
        holder.addDescriptionEdittext = task.description
        holder.addTimeEdittext        = task.time
        holder.addDateEdittext        = task.date
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    class TaskViewHolder(view : View): RecyclerView.ViewHolder(view){

        var addTitleeEdittext : EditText = view.findViewById(R.id.addTitel_edittext)
        var addDescriptionEdittext : EditText = view.findViewById(R.id.addDescription_edittext)
        var addTimeEdittext : EditText = view.findViewById(R.id.addTime_editText)
        var addDateEdittext : EditText = view.findViewById(R.id.addDate_editText)




    }


}