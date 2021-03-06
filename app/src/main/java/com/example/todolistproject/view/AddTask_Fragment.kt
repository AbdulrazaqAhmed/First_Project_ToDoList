package com.example.todolistproject.view

import android.app.DatePickerDialog
import android.graphics.Paint
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistproject.R
import java.text.SimpleDateFormat
import java.util.*


class AddTask_Fragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val add_Titleedittext: EditText = view.findViewById(R.id.addTitel_edittext)
        val add_Description: EditText = view.findViewById(R.id.addDescription_edittext)
        val popDatePicker: EditText = view.findViewById(R.id.PopDate_Picker)
        val saveButton: Button = view.findViewById(R.id.addSave_button)



        popDatePicker.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                view.context,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    popDatePicker.setText("" + year + "/" + (month + 1) + "/" + day)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }



        saveButton.setOnClickListener {
            val title = add_Titleedittext.text.toString()
            val description = add_Description.text.toString()
            val deudate = popDatePicker.text.toString()

            Log.d("deadline Initial", deudate.toString())


            var currentDate = Date()
            val format = SimpleDateFormat("yyyy/MM/dd")
            val deadline = format.parse(deudate)


            Log.d("currentDate add ", currentDate.toString())
            Log.d("deadline add", deadline.toString())

            var isDone = false
            if (currentDate > deadline) {
                isDone = false
            } else {
                isDone = true
            }

            var indicator = ""
            if (currentDate < deadline) {
                indicator = "Task is not done"
            } else {
                indicator = "Task is done"
            }


            if (title.isNotEmpty() && description.isNotEmpty()) {


                taskViewModel.addTask(title, description, deudate, isDone, indicator)

                findNavController().popBackStack()
            }


        }


    }


}