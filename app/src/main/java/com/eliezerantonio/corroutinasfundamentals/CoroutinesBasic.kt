package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //  globalScope()
//    suspendFun()
    newTopic("Constructors of coroutines ")
//    cRunBlocking()
 //   cLaunch()

    cAsync()
    readln()
}

fun cAsync() {
    runBlocking {
        newTopic("Async")

     val result =   async {
            startMsg()
            delay(someTime())
            println("async...")
            endMsg()
2
        }
        println("Async result=${result.await()}")
    }
}

fun cLaunch() {
 runBlocking {
     newTopic("Launch")
     launch {
         startMsg()
         delay(someTime())
         println("launch...")
         endMsg()
     }
 }
}

fun cRunBlocking() {

    newTopic("Run Blocking")

    runBlocking {
        startMsg()
        delay(someTime())
        println("runBlocking...")
        endMsg()
    }
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
