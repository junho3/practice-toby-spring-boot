package com.example.config

import com.example.config.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ComponentScan
@Configuration
@EnableAutoConfiguration
annotation class MySpringBootApplication()
