package com.home.data.repo

import com.home.data.Classroom

interface ClassroomRepo {
    fun getClassroom(): List<Classroom>
}