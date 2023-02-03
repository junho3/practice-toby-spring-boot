package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.support.registerBean
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val applicationContext = GenericWebApplicationContext().apply {
        registerBean<HelloController>()
        registerBean<SimpleHelloService>()
        refresh()
    }

    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(
        ServletContextInitializer { servletContext ->
            servletContext.addServlet(
                "dispatcherServlet",
                DispatcherServlet(applicationContext)
            ).addMapping("/*")
        }
    )

    webServer.start()
}
