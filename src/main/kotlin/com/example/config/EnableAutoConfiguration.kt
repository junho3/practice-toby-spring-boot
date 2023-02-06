package com.example.config

import com.example.config.autoconfig.DispatcherServletConfig
import com.example.config.autoconfig.TomcatWebServerConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DispatcherServletConfig::class, TomcatWebServerConfig::class)
annotation class EnableAutoConfiguration()
