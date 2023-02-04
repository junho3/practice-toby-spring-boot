package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext

@ComponentScan
@Configuration
class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val applicationContext: AnnotationConfigWebApplicationContext = object : AnnotationConfigWebApplicationContext() {
        override fun setClassLoader(classLoader: ClassLoader) {
            // TODO Accidental override: The following declarations have the same JVM signature 발생 해결방법을 찾지 못 함
            super.setClassLoader(classLoader)
        }

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
            register(SpringBootPracticeApplication::class.java)
            refresh()
        }
}
