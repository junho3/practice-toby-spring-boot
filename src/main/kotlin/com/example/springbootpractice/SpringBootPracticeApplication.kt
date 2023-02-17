package com.example.springbootpractice

import com.example.config.MySpringBootApplication
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MySpringBootApplication
class SpringBootPracticeApplication {

    @Bean
    fun applicationRunner(env: Environment): ApplicationRunner {
        return ApplicationRunner {
            val name = env.getProperty("my.name")
            println("name : $name")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)
}
