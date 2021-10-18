package com.nick.auth.util

import java.util.Base64

object BaseEncoder {
    fun base64Encode(string: String): String = Base64.getEncoder().encodeToString(string.toByteArray())
}
