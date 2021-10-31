package com.example.todolistproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel


class TaskDetail_Fragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels()
    private lateinit var selectedTask : TaskModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detail_, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleedittext : EditText = view.findViewById(R.id.addDetailTitel_edittext )
        val descriptionedittext : EditText = view.findViewById(R.id.addDetailDescription_edittext)
        val  timeedittext: EditText = view.findViewById(R.id.addDetailTime_editText)
        val  dateedittext: EditText = view.findViewById(R.id.addDetailDeuDate_editText)
        val saveButton : Button = view.findViewById(R.id.addDetailSave_button)

        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                titleedittext.setText("${it.title}")
                descriptionedittext.setText("${it.description}")
                timeedittext.setText("${it.time}")
                dateedittext.setText("${it.deudate}")

                selectedTask = it
            }
        })
        saveButton.setOnClickListener(){
            taskViewModel.updateTask(selectedTask)
            findNavController().popBackStack()

        }

    }



}