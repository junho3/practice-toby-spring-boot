package com.example.config.autoconfig

import org.springframework.beans.factory.annotation.Value

class ServerProperties {
    private var contextPath: String
        get() = contextPath
        set(value) { value }

    private var port: Int
        get() = port
        set(value) { value }
}
