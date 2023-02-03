package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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
                        val name = req.getParameter("name")

                        resp.status = HttpStatus.OK.value()
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                        resp.writer.println("Hello $name")
                    }
                }
            ).addMapping("/hello")
        }
    )

    webServer.start()
}
