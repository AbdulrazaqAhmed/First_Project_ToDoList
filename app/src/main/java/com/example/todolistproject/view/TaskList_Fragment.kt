package com.example.todolistproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskList_Fragment : Fragment() {
    private val tasks = mutableListOf<TaskModel>()
    private val taskViewModel : TaskViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list_, container, false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskRecyclerView : RecyclerView = view.findViewById(R.id.task_recyclerview)
        val addFloatActionButton : FloatingActionButton = view.findViewById(R.id.addTask_floatingButton)





        val taskAdapter = TaskAdapter(tasks,taskViewModel)
        taskRecyclerView.adapter = taskAdapter


        taskViewModel.taskEvent.observe(viewLifecycleOwner,{
            it?.let { item ->
                tasks.clear()
                tasks.addAll(item)
                taskAdapter.notifyDataSetChanged()
            }
        })

        addFloatActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_taskList_Fragment2_to_addTask_Fragment)
        }

    }



}