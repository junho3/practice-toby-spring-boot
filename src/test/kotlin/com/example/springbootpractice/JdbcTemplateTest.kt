package com.example.springbootpractice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@IntegrationTest
class JdbcTemplateTest {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @BeforeEach
    fun init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello(name varchar(50) primary key, count int)")
    }

    @Test
    fun insert() {
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ?)", "spring" , 3)
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ?)", "jpa", 1)
//        jdbcTemplate.update("INSERT INTO hello VALUES (?, ?)", "kafka", 2)

        val count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hello", Long::class.java)
        Assertions.assertThat(count).isEqualTo(2)
    }
}
