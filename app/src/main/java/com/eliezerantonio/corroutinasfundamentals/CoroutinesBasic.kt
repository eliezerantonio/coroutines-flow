package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //  globalScope()
    suspendFun()

    readln()
}

@OptIn(DelicateCoroutinesApi::class)
fun suspendFun() {
    newTopic("Suspended Function")
    Thread.sleep(someTime())
    GlobalScope.launch {
        delay(someTime())
    }
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
