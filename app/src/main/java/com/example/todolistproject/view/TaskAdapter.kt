package com.example.todolistproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel

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




        holder.itemView.setOnClickListener { view->
            viewModel.selectedTaskMutableLiveData.postValue(task)
            view.findNavController().navigate(R.id.action_taskList_Fragment2_to_taskDetail_Fragment2)

        }
        holder.deletetextview.setOnClickListener(){
            viewModel.deleteTask(task)
        }

    }

    override fun getItemCount(): Int {
        return tasks.size
    }
    class TaskViewHolder(view : View): RecyclerView.ViewHolder(view){

        var titletextview : TextView = view.findViewById(R.id.task_textview)
        var deletetextview : ImageButton = view.findViewById(R.id.delete_ImageButton)
        val isDone: CheckBox = view.findViewById(R.id.checkBoxTaskLayout)








    }
}







