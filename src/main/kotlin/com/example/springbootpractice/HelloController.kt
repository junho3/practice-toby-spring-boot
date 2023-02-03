package com.example.springbootpractice

class HelloController {
    fun hello(name: String?): String {
        val helloService = SimpleHelloService()
        return helloService.sayHello(requireNotNull(name))
    }
}
