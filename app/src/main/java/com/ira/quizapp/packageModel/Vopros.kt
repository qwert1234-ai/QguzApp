package com.ira.quizapp.packageModel

import com.ira.quizapp.packageModel.Answer

class Vopros(
    val text: String
) {
    val answers: MutableList<Answer> = mutableListOf()
}