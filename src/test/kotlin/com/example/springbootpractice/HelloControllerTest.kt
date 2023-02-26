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

            override fun countOf(name: String): Int {
                return 0
            }
        })

        val name = "Test"
        val result = helloController.hello(name)

        Assertions.assertThat(result).isEqualTo(name)
    }

    @Test
    fun failsHelloController() {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }

            override fun countOf(name: String): Int {
                return 0
            }
        })

        Assertions.assertThatThrownBy {
            helloController.hello(null)
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            helloController.hello("      ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
