package com.example.springbootpractice

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.registerBean
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class SpringBootPracticeApplication

fun main(args: Array<String>) {
    val applicationContext = GenericApplicationContext().apply {
        registerBean<HelloController>()
        refresh()
    }

    val serverFactory = TomcatServletWebServerFactory()
    val webServer = serverFactory.getWebServer(
        ServletContextInitializer { servletContext ->
            servletContext.addServlet(
                "frontcontroller",
                object : HttpServlet() {
                    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
                        if (req.requestURI.equals("/hello") && req.method.equals(HttpMethod.GET.name)) {
                            val name: String? = req.getParameter("name")

                            val helloController = applicationContext.getBean(HelloController::class.java)
                            val result = helloController.hello(name)

                            resp.contentType = MediaType.TEXT_PLAIN_VALUE
                            resp.writer.println(result)
                        } else {
                            resp.status = HttpStatus.NOT_FOUND.value()
                        }
                    }
                }
            ).addMapping("/*")
        }
    )

    webServer.start()
}
