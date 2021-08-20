package com.nick.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyTrackAuthApplication

fun main(args: Array<String>) {
    runApplication<MyTrackAuthApplication>(*args)
}
