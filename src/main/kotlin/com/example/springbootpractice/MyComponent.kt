package com.example.springbootpractice

import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Component
annotation class MyComponent()
