package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import com.example.config.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.env.Environment

@MyAutoConfiguration
class PropertyPostProcessorConfig {
    @Bean
    fun propertyPostProcessor(env: Environment): BeanPostProcessor {
        return object : BeanPostProcessor {
            override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
                AnnotationUtils.findAnnotation(bean.javaClass, MyConfigurationProperties::class.java) ?: return bean

                return Binder.get(env).bindOrCreate("", bean.javaClass)
            }
        }
    }
}
