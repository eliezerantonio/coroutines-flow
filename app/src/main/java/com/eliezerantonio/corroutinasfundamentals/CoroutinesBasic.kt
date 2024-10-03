package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){
    globalScope()

    readln()
}

fun globalScope() {

    newTopic("Global Scope")
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("My Coroutine")
        endMsg()
    }
}

fun startMsg() {
    println("Start Coroutine -${Thread.currentThread().name}")
}

fun endMsg() {
    println("Coroutine -${Thread.currentThread().name} Finalizada")
}
