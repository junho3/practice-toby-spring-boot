package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloControllerTest {
    @Test
    fun helloController() {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        val name = "Test"
        val result = helloController.hello(name)

        Assertions.assertThat(result).isEqualTo(name)
    }
}
