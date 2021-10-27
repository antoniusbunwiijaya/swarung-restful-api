package com.noranekoit.swarung.api.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

//tinggal panggil validasi
data class CreateProductRequest (

    //not blank untuk string
    @field:NotBlank

    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotNull
    @field:Min(value = 1)
    val price: Long?,

    @field:NotNull
    @field:Min(value = 0)
    val quantity: Int?
        )
