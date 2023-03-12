package com.ira.quizapp.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ira.quizapp.R

class LoginFragment: Fragment(){
    private var userName: String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_login,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.buttonLogin)
        checkButtonEnabled()
        button.setOnClickListener {
            val parrentController = findNavController()
            parrentController.navigate(R.id.action_loginFragment_to_quizFragment)
        }

        val userTextField = view.findViewById<TextView>(R.id.userName_TextField)
        userTextField.doOnTextChanged { text, start, before, count ->
            userName = text.toString()
            checkButtonEnabled()
        }
    }

    private fun checkButtonEnabled() {
        val button = view?.findViewById<Button>(R.id.buttonLogin)
        button?.isEnabled = !userName.isEmpty()
    }
}