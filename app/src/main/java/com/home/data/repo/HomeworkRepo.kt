package com.home.data.repo

import com.home.data.Homework

interface HomeworkRepo {

    fun getClassroom(): List<Homework>
}