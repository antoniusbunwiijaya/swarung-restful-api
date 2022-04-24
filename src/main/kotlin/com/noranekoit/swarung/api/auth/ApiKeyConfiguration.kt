package com.noranekoit.swarung.api.auth

import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
class ApiKeyConfiguration(private val apiKeyInterceptor: ApiKeyInterceptor): WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
    //untuk auto registrasi di spring apikeyinterceptornya
        registry.addWebRequestInterceptor(apiKeyInterceptor)
    }
}
