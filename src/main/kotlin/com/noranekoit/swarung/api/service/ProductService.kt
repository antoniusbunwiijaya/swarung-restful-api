package com.noranekoit.swarung.api.service

import com.noranekoit.swarung.api.model.CreateProductRequest
import com.noranekoit.swarung.api.model.ListProductRequest
import com.noranekoit.swarung.api.model.ProductResponse
import com.noranekoit.swarung.api.model.UpdateProductRequest

//udah ada bawaan jpa create dll
interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse
    fun get(id: String): ProductResponse
    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse
    fun delete(id: String)
    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}
