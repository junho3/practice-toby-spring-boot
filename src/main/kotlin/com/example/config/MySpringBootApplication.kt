package com.example.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ComponentScan
@Configuration
@EnableMyAutoConfiguration
annotation class MySpringBootApplication
