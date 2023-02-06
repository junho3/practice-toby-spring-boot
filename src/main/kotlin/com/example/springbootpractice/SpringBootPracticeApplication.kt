package com.example.springbootpractice

import com.example.config.MySpringBootApplication
import org.springframework.boot.SpringApplication

@MySpringBootApplication
class SpringBootPracticeApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)
}
