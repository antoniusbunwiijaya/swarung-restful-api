package com.noranekoit.swarung.api.controller

import com.noranekoit.swarung.api.error.NotFoundException
import com.noranekoit.swarung.api.error.UnauthorizedException
import com.noranekoit.swarung.api.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

//untuk memberikan keterangan misal vad request di validation
@RestControllerAdvice
class ErrorController {

    @ExceptionHandler
    fun validationHandler(constraintViolationException: ConstraintViolationException) : WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    //bikin pesan not found exception
    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException) : WebResponse<String>{
        return WebResponse(
            code= 404,
            status = "Not Found",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun notFound(unauthorizedException: UnauthorizedException) : WebResponse<String>{
        return WebResponse(
            code= 401,
            status = "UNAUTHORIZED",
            data = "Please put your X-Api-Key"
        )
    }
}
