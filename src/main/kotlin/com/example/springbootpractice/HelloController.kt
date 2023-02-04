package com.example.springbootpractice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService
) {
    /**
     * @ResponseBody가 없으면 리턴 타입이 String인 경우, DispatchServlet은 기본적으로 view(jsp)를 찾으려고 함. view가 없으니 404 에러를 리턴함
     * @ResponseBody를 추가하면, content-type: text/plain 를 리턴하기 때문에 view를 찾지 않고 문자열로 리턴함
     */
    @GetMapping("/hello")
    fun hello(name: String?): String {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return helloService.sayHello(name)
    }
}
