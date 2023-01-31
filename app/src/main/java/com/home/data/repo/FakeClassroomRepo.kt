package com.home.data.repo

import com.home.data.Classroom

class FakeClassroomRepo : ClassroomRepo {

    private val fakedata: List<Classroom> = listOf(
        Classroom("History", "icon", "8.00-9.00", "Mr Smith"),
        Classroom("Math", "icon", "9.00-10.00", "Mr Hide"),
        Classroom("Art", "icon", "10.00-11.00", "Mrs Ken"),
        Classroom("Music", "icon", "11.00-12.00", "Mr Roswell")
    )

    override fun getClassroom(): List<Classroom> {
        return fakedata
    }
}