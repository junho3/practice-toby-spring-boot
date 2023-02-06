package com.example.config

import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(MyConfigImportSelector::class)
annotation class EnableAutoConfiguration()
