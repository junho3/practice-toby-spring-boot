package com.example.springbootpractice

import org.springframework.stereotype.Service

@Service
class SimpleHelloService(
    private val helloRepository: HelloRepository
) : HelloService {
    override fun sayHello(name: String): String {
        helloRepository.increaseCount(name)

        return "Hello $name"
    }

    override fun countOf(name: String): Int {
        return helloRepository.countOf(name)
    }
}
