package com.example.springbootpractice

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


@Repository
class HelloRepositoryJdbc(
    private val jdbcTemplate: JdbcTemplate,
) : HelloRepository {
    override fun findByName(name: String): Hello? {
        return runCatching {
            jdbcTemplate.queryForObject<Hello>("SELECT * FROM hello WHERE name = '$name'") {
                        rs, _ -> Hello(
                    name = rs.getString("name"),
                    count = rs.getInt("count")
                )
            }
        }
            .getOrDefault(null)
    }

    override fun increaseCount(name: String) {
        when(val hello = findByName(name)) {
            null -> jdbcTemplate.update("INSERT INTO hello values(?, ?)", name, 1)
            else -> jdbcTemplate.update("UPDATE hello SET count = ? WHERE name = ?", hello.count + 1, hello.name)
        }
    }
}
