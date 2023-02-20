package com.example.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyConfigurationPropertiesImportSelector : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val attributes = importingClassMetadata
            .getAllAnnotationAttributes(EnableMyConfigurationProperties::class.java.name)
        val propertyClass = attributes?.getFirst("value")

        return arrayOf(propertyClass!!.javaClass.name)
    }
}
