package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class StartQuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_quiz, container, false)

        val btnOption1 = view.findViewById<Button>(R.id.btnOption1)
        btnOption1.setOnClickListener {
            Toast.makeText(requireContext(), "Correct!", Toast.LENGTH_SHORT).show()
        }

        // Add similar listeners for other buttons if needed
        return view
    }
}
