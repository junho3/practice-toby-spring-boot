package com.example.config.autoconfig

import org.springframework.stereotype.Component

@Component
class ServerProperties(
    val contextPath: String,
    val port: Int
)
