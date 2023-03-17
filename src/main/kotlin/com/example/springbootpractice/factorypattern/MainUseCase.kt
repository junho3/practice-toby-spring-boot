package com.example.springbootpractice.factorypattern

interface MainUseCase<in T> {
    val rule: Rule

    fun create(param: T)
    
    enum class Rule {
        APPROVE_KAKAOPAY,
        APPROVE_VIRTUAL_ACCOUNT,
        CANCEL_KAKAOPAY,
        PARTIAL_CANCEL_KAKAOPAY,
    }
}
