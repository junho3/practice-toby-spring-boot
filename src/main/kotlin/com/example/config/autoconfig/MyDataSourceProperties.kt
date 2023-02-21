package com.example.config.autoconfig

import com.example.config.MyConfigurationProperties

@MyConfigurationProperties(prefix = "data")
class MyDataSourceProperties(
    val driverClassName: String,
    val url: String,
    val username: String,
    val password: String,
)
