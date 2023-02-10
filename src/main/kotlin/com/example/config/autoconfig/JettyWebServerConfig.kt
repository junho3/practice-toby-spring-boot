package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import com.example.config.MySpringBootApplication
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@MyAutoConfiguration
class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory {
        return JettyServletWebServerFactory()
    }
}
