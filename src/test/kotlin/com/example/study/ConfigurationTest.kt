package com.example.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest {
    @Test
    fun `common 객체 2개가 주어졌을 때 common 객체는 서로 다른 객체이다`() {
        Assertions.assertThat(Common()).isNotSameAs(Common())
    }

    @Test
    fun `common 객체가 선언된 변수가 주어졌을 때 common 객체는 서로 같은 객체이다`() {
        val common = Common()
        Assertions.assertThat(common).isSameAs(common)
    }

    @Test
    fun `bean1 객체와 bean2 객체가 주어졌을 때 common 객체는 서로 다른 객체이다`() {
        val myConfig = MyConfig()
        val bean1 = myConfig.bean1()
        val bean2 = myConfig.bean2()

        Assertions.assertThat(bean1._common).isNotSameAs(bean2._common)
    }

    @Test
    fun `ApplicationContext로 생성된 bean1 객체와 bean2 객체가 주어졌을 때 common 객체는 서로 같은 객체이다`() {
        val annotationConfigApplicationContext = AnnotationConfigApplicationContext()
        annotationConfigApplicationContext.register(MyConfig::class.java)
        annotationConfigApplicationContext.refresh()

        val bean1 = annotationConfigApplicationContext.getBean(Bean1::class.java)
        val bean2 = annotationConfigApplicationContext.getBean(Bean2::class.java)

        Assertions.assertThat(bean1._common).isSameAs(bean2._common)
    }

    @Test
    fun `Proxy 메소드로 생성된 bean1 객체와 bean2 객체가 주어졌을 때 common 객체는 서로 같은 객체이다`() {
        val myConfigProxy = MyConfigProxy()
        val bean1 = myConfigProxy.bean1()
        val bean2 = myConfigProxy.bean2()

        Assertions.assertThat(bean1._common).isSameAs(bean2._common)
    }

    /**
     * @Configuration 어노테이션은 내부적으로 Proxy 객체를 생성함
     * 생성해야할 객체가 null인 경우 객체를 할당하고, null이 아닌경우 리턴함
     */
    internal class MyConfigProxy : MyConfig() {
        private var common: Common? = null
        override fun common(): Common {
            if (common == null) {
                common = super.common()
            }

            return common!!
        }
    }

    @Configuration
    internal class MyConfig {
        @Bean
        fun common(): Common {
            return Common()
        }

        @Bean
        fun bean1(): Bean1 {
            return Bean1(common())
        }

        @Bean
        fun bean2(): Bean2 {
            return Bean2(common())
        }
    }

    internal class Bean1(private val common: Common) {
        val _common: Common
            get() = common
    }

    internal class Bean2(private val common: Common) {
        val _common: Common
            get() = common
    }

    internal class Common
}
