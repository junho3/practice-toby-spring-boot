package com.example.springbootpractice

interface HelloRepository {
    fun findByName(name: String): Hello?

    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        val hello = findByName(name)
        return hello?.count ?: 0
    }
}
