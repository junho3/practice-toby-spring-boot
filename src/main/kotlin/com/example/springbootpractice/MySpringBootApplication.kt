package com.example.springbootpractice

import com.example.config.DispatcherServletConfig
import com.example.config.TomcatWebServerConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ComponentScan
@Configuration
@Import(DispatcherServletConfig::class, TomcatWebServerConfig::class)
annotation class MySpringBootApplication()
