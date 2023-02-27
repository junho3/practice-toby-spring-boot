package com.example.springbootpractice

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
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
    val context = SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)

    val jdbcTemplate = context.getBean(JdbcTemplate::class.java)
    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)")
}
