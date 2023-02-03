package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(
        ServletContextInitializer { servletContext ->
            servletContext.addServlet(
                "hello",
                object : HttpServlet() {
                    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
                        resp.status = 200
                        resp.setHeader("Content-Type", "text/plain")
                        resp.writer.println("Hello Servlet")
                    }
                }
            ).addMapping("/hello")
        }
    )

    webServer.start()
}
