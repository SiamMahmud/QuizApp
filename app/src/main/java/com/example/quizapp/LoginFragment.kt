package com.example.quizapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.checkbox.MaterialCheckBox

class LoginFragment : Fragment() {

    private lateinit var emailEt: TextInputEditText
    private lateinit var passwordEt: TextInputEditText
    private lateinit var signInBtn: Button
    private lateinit var checkBox: MaterialCheckBox
    private lateinit var loginErrorTv: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize Views
        emailEt = view.findViewById(R.id.emailEt)
        passwordEt = view.findViewById(R.id.passwordEt)
        signInBtn = view.findViewById(R.id.btnSignIn)
        checkBox = view.findViewById(R.id.btnCheckbox)
        loginErrorTv = view.findViewById(R.id.loginErrorTv)

        // Hide error message initially
        loginErrorTv.visibility = View.GONE

        signInBtn.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val email = emailEt.text.toString().trim()
        val password = passwordEt.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            loginErrorTv.visibility = View.VISIBLE
            loginErrorTv.text = "Please enter both email and password"
            return
        }

        if (email == "ds@gmail.com" && password == "ds12345678") {
            // Save login state with SharedPreferences
            if (checkBox.isChecked) {
                val sharedPref = requireActivity().getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("isLoggedIn", true)
                    putString("userEmail", email)
                    apply()
                }
            }

            // Navigate to Dashboard
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        } else {
            loginErrorTv.visibility = View.VISIBLE
            loginErrorTv.text = "Invalid email or password"
        }
    }
}
