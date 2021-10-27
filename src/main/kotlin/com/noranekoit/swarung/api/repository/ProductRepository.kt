package com.noranekoit.swarung.api.repository

import com.noranekoit.swarung.api.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

//entity,id
//gak perlu buat updtae delete karena udah bawaan jpa
interface ProductRepository : JpaRepository<Product, String> {
}
