package com.example.springbootpractice

import org.springframework.boot.SpringApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.DispatcherServlet

@MySpringBootAnnotation
class SpringBootPracticeApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)
}
