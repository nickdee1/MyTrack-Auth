package com.nick.auth.handler

import com.nick.auth.api.error.RestError
import com.nick.auth.exception.AuthException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class DefaultErrorHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(AuthException::class)])
    fun handleAuthException(ex: AuthException): ResponseEntity<RestError> {
        val errorBody = RestError(
            message = ex.reason,
            scope = ex.scope
        )
        return ResponseEntity(errorBody, ex.httpStatus)
    }
}
