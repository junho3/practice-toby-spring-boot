package com.example.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.BeansException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest {
    @Test
    fun `Config1이 TrueCondition일 때, MyBean이 ApplicationContext에 존재한다`() {
        val applicationContext = AnnotationConfigApplicationContext()
        applicationContext.register(Config1::class.java)
        applicationContext.refresh()

        val bean = applicationContext.getBean(MyBean::class.java)

        Assertions.assertThat(bean).isInstanceOf(MyBean::class.java)
    }

    @Test
    fun `Config2가 FalseCondition일 때, BeansException을 던진다`() {
        val applicationContext = AnnotationConfigApplicationContext()
        applicationContext.register(Config2::class.java)
        applicationContext.refresh()

        Assertions.assertThatThrownBy {
            applicationContext.getBean(MyBean::class.java)
        }.isInstanceOf(BeansException::class.java)
    }

    @Configuration
    @Conditional(TrueCondition::class)
    class Config1 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @Conditional(FalseCondition::class)
    class Config2 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    class MyBean

    class TrueCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return true
        }
    }

    class FalseCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return false
        }
    }
}
