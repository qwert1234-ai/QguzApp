package com.ira.quizapp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ira.quizapp.R
import com.ira.quizapp.helpers.DataManager
import com.ira.quizapp.packageModel.Vopros
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class QuizFragment: Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    private var currentIndex = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeLabel  = view.findViewById<TextView>(R.id.welcome_lab)
        welcomeLabel.text = getString(R.string.quiz_welcome_label, dataManager.userName)

        displayQuestion(dataManager.test.vopros[currentIndex])
        val  buttonAnswer = view.findViewById<Button>(R.id.next_button)
        buttonAnswer.setOnClickListener {
            currentIndex +=1
            if (currentIndex < dataManager.test.vopros.size) {
                displayQuestion(dataManager.test.vopros[currentIndex])
            }
        }
    }
    private fun displayQuestion(currentQuestion: Vopros){
        val questionLabel: TextView? = view?.findViewById<TextView>(R.id.question_label)
        questionLabel?.text = currentQuestion.text

        val variant_1 = view?.findViewById<RadioButton>(R.id.v_1)
        val variant_2 = view?.findViewById<RadioButton>(R.id.v_2)
        val variant_3 = view?.findViewById<RadioButton>(R.id.v_3)

        variant_1?.text = currentQuestion.answers[0].text
        variant_2?.text = currentQuestion.answers[1].text
        variant_3?.text = currentQuestion.answers[2].text
    }
}