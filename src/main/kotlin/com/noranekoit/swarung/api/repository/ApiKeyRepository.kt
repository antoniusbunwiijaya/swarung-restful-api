package com.noranekoit.swarung.api.repository

import com.noranekoit.swarung.api.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey,String> {
}
