package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.support.registerBean
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext

class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val applicationContext: GenericWebApplicationContext = object : GenericWebApplicationContext() {
        override fun onRefresh() {
            super.onRefresh()
            val serverFactory: ServletWebServerFactory = TomcatServletWebServerFactory()
            val webServer = serverFactory.getWebServer(
                ServletContextInitializer { servletContext: ServletContext ->
                    servletContext.addServlet(
                        "dispatcherServlet",
                        DispatcherServlet(this)
                    )
                        .addMapping("/*")
                }
            )
            webServer.start()
        }
    }
        .apply {
            registerBean<HelloController>()
            registerBean<SimpleHelloService>()
            refresh()
        }
}
