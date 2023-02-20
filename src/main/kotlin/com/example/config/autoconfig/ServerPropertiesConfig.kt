package com.example.config.autoconfig

import org.springframework.boot.context.properties.bind.Binder
import org.springframework.core.env.Environment

class ServerPropertiesConfig {
    fun serverProperties(environment: Environment) : ServerProperties {
        return Binder.get(environment).bind("", ServerProperties::class.java).get()
    }
}
