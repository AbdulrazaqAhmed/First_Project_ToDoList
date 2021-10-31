package com.example.todolistproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistproject.R




class AddTask_Fragment : Fragment() {
    private val taskViewModel : TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task_, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val add_Titleedittext : EditText = view.findViewById(R.id.addTitel_edittext)
        val add_Description : EditText = view.findViewById(R.id.addDescription_edittext)
        val add_Deudateedittext : EditText = view.findViewById(R.id.addDeuDate_editText)
        val add_Timeedittext : EditText = view.findViewById(R.id.addTime_editText)
        val saveButton : Button = view.findViewById(R.id.addSave_button)
/*
* calender
* */
        saveButton.setOnClickListener{
            val title = add_Titleedittext.text.toString()
            val description = add_Description.text.toString()
            val deudate = add_Deudateedittext.text.toString()
            val time   = add_Timeedittext.text.toString()


            if (title.isNotEmpty() && description.isNotEmpty()) {


                taskViewModel.addTask(title, description, deudate,time)

                findNavController().popBackStack()
            }


        }


    }



}