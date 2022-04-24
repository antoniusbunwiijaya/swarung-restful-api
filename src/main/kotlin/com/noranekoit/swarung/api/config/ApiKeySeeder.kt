package com.noranekoit.swarung.api.config

import com.noranekoit.swarung.api.entity.ApiKey
import com.noranekoit.swarung.api.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

///application runner akan dieksekusi pertama kali berjalan dieksekusi
//component biar terintegrasi di spring
@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository): ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val entity = ApiKey(id = apiKey)
            //save itu bisa menbuat baru tapi bisa duplikat
            apiKeyRepository.save(entity)
        }
    }


}
