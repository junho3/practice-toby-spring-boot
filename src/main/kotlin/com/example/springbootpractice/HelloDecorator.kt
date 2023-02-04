package com.example.springbootpractice

import org.springframework.stereotype.Service

@Service
class HelloDecorator(
    private val helloService: HelloService
) : HelloService {
    override fun sayHello(name: String): String {
        return "*" + helloService.sayHello(name) + "*"
    }
}
