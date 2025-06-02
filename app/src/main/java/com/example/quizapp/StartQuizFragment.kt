package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

class StartQuizFragment : Fragment() {

    private lateinit var tvQuestion: TextView
    private lateinit var btnOption1: Button
    private lateinit var btnOption2: Button
    private lateinit var btnOption3: Button
    private lateinit var btnOption4: Button

    private val questions = listOf(
        Question(
            text = "What is the capital of France?",
            options = listOf("Paris", "Rome", "London", "Berlin"),
            correctAnswerIndex = 0 // Paris is the correct answer
        ),
        Question(
            text = "What is the largest planet in our solar system?",
            options = listOf("Earth", "Mars", "Jupiter", "Saturn"),
            correctAnswerIndex = 2 // Jupiter is the correct answer
        ),
        Question(
            text = "What is the chemical symbol for water?",
            options = listOf("O2", "H2O", "CO2", "NaCl"),
            correctAnswerIndex = 1 // H2O is the correct answer
        )
    )

    private var currentQuestionIndex = 0

    private val args: StartQuizFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_quiz, container, false)

        tvQuestion = view.findViewById(R.id.tvQuestion)
        btnOption1 = view.findViewById(R.id.btnOption1)
        btnOption2 = view.findViewById(R.id.btnOption2)
        btnOption3 = view.findViewById(R.id.btnOption3)
        btnOption4 = view.findViewById(R.id.btnOption4)

        currentQuestionIndex = args.questionIndex

        displayQuestion(currentQuestionIndex)

        btnOption1.setOnClickListener {
            checkAnswer(0)
        }

        btnOption2.setOnClickListener {
            checkAnswer(1)
        }

        btnOption3.setOnClickListener {
            checkAnswer(2)
        }

        btnOption4.setOnClickListener {
            checkAnswer(3)
        }

        return view
    }

    private fun displayQuestion(index: Int) {
        if (index < questions.size) {
            val question = questions[index]
            tvQuestion.text = question.text
            btnOption1.text = question.options[0]
            btnOption2.text = question.options[1]
            btnOption3.text = question.options[2]
            btnOption4.text = question.options[3]
        } else {
            // End of quiz, navigate back to dashboard
            findNavController().navigate(R.id.dashboardFragment)
        }
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        val correctAnswerIndex = questions[currentQuestionIndex].correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex) {
            // Correct answer
            val action = StartQuizFragmentDirections.actionStartQuizFragmentToCorrectAnswerFragment(currentQuestionIndex)
            findNavController().navigate(action)
        } else {
            // Incorrect answer
            val action = StartQuizFragmentDirections.actionStartQuizFragmentToIncorrectAnswerFragment(currentQuestionIndex)
            findNavController().navigate(action)
        }
    }
}
