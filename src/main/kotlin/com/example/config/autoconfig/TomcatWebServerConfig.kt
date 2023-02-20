package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.MyAutoConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean


@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig {
    @Value("\${contextPath}")
    lateinit var contextPath: String

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    fun servletWebServerFactory(): ServletWebServerFactory {
        val factory = TomcatServletWebServerFactory()
        factory.contextPath = contextPath

        return factory
    }
}
