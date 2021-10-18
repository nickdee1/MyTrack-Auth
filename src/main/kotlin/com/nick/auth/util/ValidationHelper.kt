package com.nick.auth.util

object ValidationHelper {

    fun isValidPassword(password: String): Boolean {
        if (password.isBlank()) {
            return false
        }
        if (password.length < 6 || password.length > 100) {
            return false
        }
        val anyDigit = password.any { char -> char.isDigit() }
        val anyUpperCase = password.any { char -> char.isUpperCase() }
        val anyLowerCase = password.any { char -> char.isUpperCase() }
        val anySymbol = password.any { char -> !char.isLetterOrDigit() }
        if (!anyDigit || !anyUpperCase || !anyLowerCase || !anySymbol) {
            return false
        }
        return true
    }
}
