package com.noranekoit.swarung.api.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class ValidationUtil(val validator: Validator) {
    //object any
    fun validate(any: Any){
        val result = validator.validate(any)
        //kalau result = 0 valid kalau tidak sama sengan 0 tidak valid
        if (result.size !=0){
            throw ConstraintViolationException(result)
        }
    }
}
