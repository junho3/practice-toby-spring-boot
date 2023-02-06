package com.example.springbootpractice

import org.springframework.boot.SpringApplication

@MySpringBootApplication
class SpringBootPracticeApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)
}
