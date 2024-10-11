package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    coldFlow()
}

fun coldFlow() {
    newTopic("Flow are cold")

    runBlocking {
        val dataFlow = getDataByFlow()
        println("Waiting...")
        delay(someTime())
        dataFlow.collect { println(it) }
    }
}
