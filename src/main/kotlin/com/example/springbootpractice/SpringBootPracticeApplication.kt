package com.example.springbootpractice

import org.springframework.boot.SpringApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@ComponentScan
@Configuration
class SpringBootPracticeApplication {
    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory {
        return TomcatServletWebServerFactory()
    }

    @Bean
    fun dispatcherServlet(): DispatcherServlet {
        return DispatcherServlet()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootPracticeApplication::class.java, *args)
//    MySpringApplication.run(SpringBootPracticeApplication::class.java, *args)
}
