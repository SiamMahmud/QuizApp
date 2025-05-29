package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class DashboardFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var btnStartQuiz: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        etName = view.findViewById(R.id.etName)
        btnStartQuiz = view.findViewById(R.id.btnStartQuiz)

        btnStartQuiz.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                etName.error = "Please enter your name"
            } else {
                // Proceed to quiz fragment
                Toast.makeText(requireContext(), "Welcome $name!", Toast.LENGTH_SHORT).show()
                 findNavController().navigate(R.id.startQuizFragment)
            }
        }
        return view
    }
}
