package com.example.todolistproject.view

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel
import java.text.SimpleDateFormat
import java.util.*

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

        holder.titletextview.text = task.title
        holder.isDone.isChecked = task.isDone
        holder.inDecator.text = task.indecater






        holder.itemView.setOnClickListener { view->
            viewModel.selectedTaskMutableLiveData.postValue(task)
            view.findNavController().navigate(R.id.action_taskList_Fragment2_to_taskDetail_Fragment2)

        }
        holder.deletetextview.setOnClickListener(){
            viewModel.deleteTask(task)
        }




        var currentDate = Date()
        val format = SimpleDateFormat("yyyy/MM/dd")
        val deadline = format.parse(task.deudate)


        Log.d("currentDate list", currentDate.toString())
        Log.d("deadline list", deadline.toString())

        if (currentDate > deadline && !task.isDone) {
            holder.titletextview.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.inDecator.text = "Pass Due Date "



        }
        var text = task.indecater

        holder.isDone.setOnClickListener (){



            if (task.isDone) {
                text = "Task is Not Done"
                holder.inDecator.text =  text


            } else {
                text = "Task is Done"
                holder.inDecator.text = text

            }

            task.isDone = holder.isDone.isChecked
            task.indecater = holder.inDecator.text.toString()
            viewModel.updateTask(task)
        }



    }

    override fun getItemCount(): Int {
        return tasks.size
    }
    class TaskViewHolder(view : View): RecyclerView.ViewHolder(view){

        var titletextview : TextView = view.findViewById(R.id.task_textview)
        var deletetextview : ImageButton = view.findViewById(R.id.delete_ImageButton)
        val isDone: CheckBox = view.findViewById(R.id.checkBoxTaskLayout)
        var inDecator : TextView = view.findViewById(R.id.indecator_textView)






    }
}







