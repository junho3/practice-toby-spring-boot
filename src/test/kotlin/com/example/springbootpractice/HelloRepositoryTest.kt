package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    @Autowired
    lateinit var helloRepository: HelloRepository

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun failToFindByName() {
        Assertions.assertThat(helloRepository.findByName("Spring")).isNull()
    }

    @Test
    fun increaseCount() {
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(0)

        helloRepository.increaseCount("Spring")
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(1)

        helloRepository.increaseCount("Spring")
        Assertions.assertThat(helloRepository.countOf("Spring")).isEqualTo(2)
    }
}
