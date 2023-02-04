package com.example.springbootpractice

import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext

class MySpringApplication {
    companion object {
        fun run(applicationClass: Class<*>, vararg args: String) {
            val applicationContext: AnnotationConfigWebApplicationContext =
                object : AnnotationConfigWebApplicationContext() {
                    override fun setClassLoader(classLoader: ClassLoader) {
                        // TODO Accidental override: The following declarations have the same JVM signature 발생 해결방법을 찾지 못 함
                        super.setClassLoader(classLoader)
                    }

                    override fun onRefresh() {
                        super.onRefresh()
                        val serverFactory: ServletWebServerFactory = getBean(ServletWebServerFactory::class.java)
                        val dispatcherServlet: DispatcherServlet = getBean(DispatcherServlet::class.java)
                        dispatcherServlet.setApplicationContext(this)

                        val webServer = serverFactory.getWebServer(
                            ServletContextInitializer { servletContext: ServletContext ->
                                servletContext.addServlet(
                                    "dispatcherServlet",
                                    dispatcherServlet
                                )
                                    .addMapping("/*")
                            }
                        )
                        webServer.start()
                    }
                }
                    .apply {
                        register(applicationClass)
                        refresh()
                    }
        }
    }
}
