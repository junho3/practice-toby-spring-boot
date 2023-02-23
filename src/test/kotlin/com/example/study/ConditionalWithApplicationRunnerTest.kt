package com.example.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalWithApplicationRunnerTest {
    @Test
    fun `Config1이 TrueCondition일 때, MyBean이 ApplicationContext에 존재한다`() {
        ApplicationContextRunner().withUserConfiguration(Config1::class.java)
            .run {
                Assertions.assertThat(it).hasSingleBean(Config1::class.java)
                Assertions.assertThat(it).hasSingleBean(MyBean::class.java)
            }
    }

    @Test
    fun `Config2가 FalseCondition일 때, MyBean이 ApplicationContext에 존재하지 않는다`() {
        ApplicationContextRunner().withUserConfiguration(Config2::class.java)
            .run {
                Assertions.assertThat(it).doesNotHaveBean(Config2::class.java)
                Assertions.assertThat(it).doesNotHaveBean(MyBean::class.java)
            }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(
        val value: Boolean
    )

    @Configuration
    @BooleanConditional(true)
    class Config1 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @BooleanConditional(false)
    class Config2 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    class MyBean

    class BooleanCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return metadata.annotations.get(BooleanConditional::class.java)
                .asAnnotationAttributes()
                .getValue("value")
                .toString()
                .toBoolean()
        }
    }
}
