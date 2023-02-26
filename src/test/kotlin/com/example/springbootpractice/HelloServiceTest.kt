package com.example.springbootpractice

import org.assertj.core.api.Assertions

class HelloServiceTest {
    @UnitTest
    fun simpleHelloService() {
        val helloService = SimpleHelloService(createHelloRepository())
        val name = "Test"

        val result = helloService.sayHello(name)

        Assertions.assertThat(result).isEqualTo("Hello $name")
    }
    @FastUnitTest
    fun helloDecorator() {
        val helloDecorator = HelloDecorator(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })
        val name = "Test"

        val result = helloDecorator.sayHello(name)

        Assertions.assertThat(result).isEqualTo("*${name}*")
    }

    private fun createHelloRepository(): HelloRepository {
        return object : HelloRepository {
            override fun findByName(name: String): Hello? {
                return null
            }

            override fun increaseCount(name: String) {}
        }
    }
}
