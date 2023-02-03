package com.example.springbootpractice

class HelloController(private val helloService: HelloService) {
    fun hello(name: String?): String {
        return helloService.sayHello(requireNotNull(name))
    }
}
