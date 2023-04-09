package com.ira.quizapp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
    private  var variantGroup: RadioGroup? = null
    private var variant1: RadioButton? = null
    private var variant2: RadioButton? = null
    private var variant3: RadioButton? = null
    private var buttonAnswer: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        variant1 = view.findViewById(R.id.v_1)
        variant1?.setOnClickListener{
            buttonAnswer?.isEnabled = true
        }
        variant2 = view.findViewById(R.id.v_2)
        variant2?.setOnClickListener{
            buttonAnswer?.isEnabled = true
        }
        variant3 = view.findViewById(R.id.v_3)
        variant3?.setOnClickListener{
            buttonAnswer?.isEnabled = true
        }

        variantGroup = view.findViewById(R.id.radioGroup)

        val welcomeLabel  = view.findViewById<TextView>(R.id.welcome_lab)
        welcomeLabel.text = getString(R.string.quiz_welcome_label, dataManager.userName)

        displayQuestion(dataManager.test.vopros[currentIndex])

        buttonAnswer = view.findViewById<Button>(R.id.next_button)
        buttonAnswer?.isEnabled = false
        buttonAnswer?.setOnClickListener {
            val currentQuestion = dataManager.test.vopros[currentIndex]
            val index = currentQuestion.answers.indexOfFirst{ currenAnswer ->
                currenAnswer.isCorrect == true
            }
            if (index == 0){
                if (variant1?.isChecked == true){
                    dataManager.test.score += 1
                }
            }else if(index == 1) {
                if (variant2?.isChecked == true){
                    dataManager.test.score += 1
                }
            } else if(index == 2) {
                if (variant3?.isChecked == true){
                    dataManager.test.score += 1
                }
            }


            currentIndex +=1
            if (currentIndex < dataManager.test.vopros.size) {
                displayQuestion(dataManager.test.vopros[currentIndex])
            }else {
                findNavController().navigate(R.id.resultFragment)
            }
        }
    }
    private fun displayQuestion(currentQuestion: Vopros){


        val questionLabel: TextView? = view?.findViewById<TextView>(R.id.question_label)
        questionLabel?.text = currentQuestion.text

        buttonAnswer?.isEnabled = false
        variantGroup?.clearCheck()

        variant1?.text = currentQuestion.answers[0].text
        variant2?.text = currentQuestion.answers[1].text
        variant3?.text = currentQuestion.answers[2].text
    }
}