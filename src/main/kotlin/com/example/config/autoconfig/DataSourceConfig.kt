package com.example.config.autoconfig

import com.example.config.ConditionalMyOnClass
import com.example.config.EnableMyConfigurationProperties
import com.example.config.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.Driver
import javax.sql.DataSource

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
@EnableTransactionManagement
class DataSourceConfig {
    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    @ConditionalOnMissingBean
    fun hikariDataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = HikariDataSource()

        dataSource.driverClassName = properties.driverClassName
        dataSource.jdbcUrl = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnMissingBean
    fun dataSource(properties: MyDataSourceProperties): DataSource {
        val dataSource = SimpleDriverDataSource()

        dataSource.setDriverClass(Class.forName(properties.driverClassName) as Class<out Driver>)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password

        return dataSource
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class) // DataSource Bean이 1개만 존재할 때 해당 Bean을 가져와서 사용하겠다라는 의미
    fun jdbcTemplate(dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class)
    fun jdbcTransactionManager(dataSource: DataSource): JdbcTransactionManager {
        return JdbcTransactionManager(dataSource)
    }
}
