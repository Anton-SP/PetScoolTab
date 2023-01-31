package com.home.data.repo

import com.home.data.Classroom
import com.home.data.Homework

class FakeHomeworkRepo : HomeworkRepo {

    private val fakeHomeworkData: List<Homework> = listOf(
        Homework("History", "icon", "8.00-9.00", "Read chapter 12"),
        Homework("Math", "icon", "9.00-10.00", "Complete ex 78 and 79"),
        Homework("Art", "icon", "10.00-11.00", "Draw a family portrait"),
        Homework("Music", "icon", "11.00-12.00", "Choose your favorite song")
    )

    override fun getClassroom(): List<Homework> {
        return fakeHomeworkData
    }
}