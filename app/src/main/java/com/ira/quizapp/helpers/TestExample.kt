package com.ira.quizapp.helpers

import com.ira.quizapp.packageModel.Answer
import com.ira.quizapp.packageModel.Test
import com.ira.quizapp.packageModel.Vopros

val question1 = Vopros("2*2").apply {
    val answer1 = Answer(
        "2",
        false
    )
    this.answers.add(answer1)

    val answer2 = Answer(
        "4",
        true
    )
    this.answers.add(answer2)

    val answer3 = Answer(
        "6",
        false
    )
    this.answers.add(answer3)
}

val question2 = Vopros("4*4").apply {
    val answer1 = Answer(
        "16",
        true
    )
    this.answers.add(answer1)

    val answer2 = Answer(
        "8",
        false
    )
    this.answers.add(answer2)

    val answer3 = Answer(
        "10",
        false
    )
    this.answers.add(answer3)
}

val question3 = Vopros("16*16").apply {
    val answer1 = Answer(
        "32",
        false
    )
    this.answers.add(answer1)

    val answer2 = Answer(
        "47",
        false
    )
    this.answers.add(answer2)

    val answer3 = Answer(
        "256",
        true
    )
    this.answers.add(answer3)
}
val testExamle = Test().apply {
    this.vopros.add(question1)
    this.vopros.add(question2)
    this.vopros.add(question3)
}