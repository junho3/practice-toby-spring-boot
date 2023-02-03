package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory

class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer()
    webServer.start()
}
