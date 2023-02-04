package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@UnitTest
annotation class FastUnitTest

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Test
annotation class UnitTest

class HelloServiceTest {
    @UnitTest
    fun simpleHelloService() {
        val helloService = SimpleHelloService()
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
}
