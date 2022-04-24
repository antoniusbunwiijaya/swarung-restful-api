package com.noranekoit.swarung.api.service.impl

import com.noranekoit.swarung.api.entity.Product
import com.noranekoit.swarung.api.error.NotFoundException
import com.noranekoit.swarung.api.model.CreateProductRequest
import com.noranekoit.swarung.api.model.ListProductRequest
import com.noranekoit.swarung.api.model.ProductResponse
import com.noranekoit.swarung.api.model.UpdateProductRequest
import com.noranekoit.swarung.api.repository.ProductRepository
import com.noranekoit.swarung.api.service.ProductService
import com.noranekoit.swarung.api.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

//dependecy injection productRepository
@Service
class ProductServiceImpl(val productRepository: ProductRepository,
                         val validationUtil: ValidationUtil
): ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        //panggil validasi dulu
        validationUtil.validate(createProductRequest)

        //create atau insert data product ke database
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        //set ke database
        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        //ambil id dari repository
        val product = findProductByIdorThrowNotFound(id)
        return convertProductToProductResponse(product)

    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductByIdorThrowNotFound(id)

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()

        }

        productRepository.save(product)
        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdorThrowNotFound(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page,listProductRequest.size))
        val products : List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductByIdorThrowNotFound(id: String): Product{
        val product = productRepository.findByIdOrNull(id)
        if (product== null){
            throw NotFoundException()
        }else{
            return product
        }
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse{
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt

        )
    }

}
