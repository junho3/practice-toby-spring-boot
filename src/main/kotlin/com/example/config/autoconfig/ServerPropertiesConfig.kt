package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfiguration
class ServerPropertiesConfig {
    @Bean
    fun serverProperties(environment: Environment) : ServerProperties {
        return ServerProperties(
            contextPath = environment.getProperty("contextPath").orEmpty(),
            port = environment.getProperty("port").orEmpty().toInt(),
        )
    }
}
