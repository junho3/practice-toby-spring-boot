package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloServiceCountTest {
    @Autowired
    lateinit var helloService: HelloService
    @Autowired
    lateinit var helloRepository: HelloRepository
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun sayHelloIncreaseCount() {
        for (count: Int in 1..10) {
            helloService.sayHello("Spring")
            Assertions.assertThat(requireNotNull(helloRepository.findByName("Spring")).count).isEqualTo(count)
        }
    }
}
