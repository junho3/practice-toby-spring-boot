package com.example.springbootpractice.factorypattern

import org.springframework.stereotype.Component
import org.springframework.util.CollectionUtils

@Component
class MainUseCaseFactory(useCases: List<MainUseCase<Any>>) {
    private val useCases: MutableMap<MainUseCase.Rule, MainUseCase<Any>> = mutableMapOf()

    init {
        require(!CollectionUtils.isEmpty(useCases)) { "존재하는 UseCase가 없음" }
        useCases.forEach { this.useCases[it.rule] = it }
    }

    fun getUseCase(rule: String): MainUseCase<Any> {
        return useCases.takeIf { it.containsKey(MainUseCase.Rule.valueOf(rule)) }
            ?.get(MainUseCase.Rule.valueOf(rule))
            ?: throw IllegalArgumentException("에러")
    }
}

