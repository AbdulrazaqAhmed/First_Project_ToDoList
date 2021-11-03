package com.example.todolistproject.view

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todolistproject.R
import com.example.todolistproject.database.TaskModel
import java.text.SimpleDateFormat
import java.util.*


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
        val popDatePicker : EditText = view.findViewById(R.id.PopDate_DetailPicker)
        val currentTimetextView : TextView = view.findViewById(R.id.currentTimetext)
        val saveButton : Button = view.findViewById(R.id.addDetailSave_button)

        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                titleedittext.setText("${it.title}")
                descriptionedittext.setText("${it.description}")
                popDatePicker.setText("${it.deudate}")
                currentTimetextView.text = it.creationDate
                popDatePicker.setOnClickListener {
                    val calendar: Calendar = Calendar.getInstance()
                    val year: Int = calendar.get(Calendar.YEAR)
                    val month: Int = calendar.get(Calendar.MONTH)
                    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)


                    val datePickerDialog = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, day ->
                        popDatePicker.setText("" + year + "/" + (month+1)+ "/" + day)
                    }, year, month, day)

                    datePickerDialog.show()
                }






                selectedTask = it
            }
        })
        saveButton.setOnClickListener(){

            selectedTask.title = titleedittext.text.toString()
            selectedTask.description = descriptionedittext.text.toString()

            val format = SimpleDateFormat("yyyy/MM/dd")
            val deadline = format.parse(popDatePicker.text.toString())

            selectedTask.deudate = popDatePicker.text.toString()

            taskViewModel.updateTask(selectedTask)
            findNavController().popBackStack()

        }

    }



}