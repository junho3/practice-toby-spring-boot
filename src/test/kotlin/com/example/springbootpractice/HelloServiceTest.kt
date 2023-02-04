package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloServiceTest {
    @Test
    fun simpleHelloService() {
        val helloService = SimpleHelloService()
        val name = "Test"

        val result = helloService.sayHello(name)

        Assertions.assertThat(result).isEqualTo("Hello $name")
    }
}
