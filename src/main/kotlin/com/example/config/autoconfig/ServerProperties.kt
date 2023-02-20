package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

@MyConfigurationProperties
class ServerProperties(
    val contextPath: String,
    val port: Int
)
