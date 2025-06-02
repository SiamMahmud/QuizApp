package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class CorrectAnswerFragment : Fragment() {

    private val args: CorrectAnswerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_correct_answer, container, false)
        val ivConfetti = view.findViewById<ImageView>(R.id.ivConfetti)
        val btnNextQuestion = view.findViewById<Button>(R.id.btnNextQuestion)

        // Load the GIF using Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.confetti_animation)
            .into(ivConfetti)

        btnNextQuestion.setOnClickListener {
            val nextQuestionIndex = args.answeredQuestionIndex + 1
            val action = CorrectAnswerFragmentDirections.actionCorrectAnswerFragmentToStartQuizFragment(nextQuestionIndex)
            findNavController().navigate(action)
        }

        return view
    }
} 