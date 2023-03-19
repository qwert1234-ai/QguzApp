package com.ira.quizapp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ira.quizapp.R
import com.ira.quizapp.helpers.DataManager
import javax.inject.Inject

class QuizFragment: Fragment() {
    @Inject
    lateinit var dataManager : DataManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("userName : $ {dataManager.userName}")
    }
}