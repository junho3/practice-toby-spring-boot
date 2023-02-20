package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MyAutoConfiguration
class ServerPropertiesConfig {
    @Bean
    fun serverProperties(environment: Environment) : ServerProperties {
        return Binder.get(environment).bind("", ServerProperties::class.java).get()
    }
}
