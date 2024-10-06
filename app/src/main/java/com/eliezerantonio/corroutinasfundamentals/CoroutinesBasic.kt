package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //  globalScope()
    //  suspendFun()
    //  newTopic("Constructors of coroutines ")
    //  cRunBlocking()
    //  cLaunch()
    //  cAsync()

    //job()//

    deferred()
    readln()
}

fun deferred() {

    runBlocking {
        newTopic("Deferred")
        val deferred = async {
            startMsg()
            delay(someTime())
            println("Deferred")
            endMsg()
            multi(5, 2)
        }

        println("Deferred: $deferred")
        println("Value of deferred.await: ${deferred.await()}")

        val result = async {
            multi(3, 3)
        }.await()

        print("Result $result")
    }
}

fun job() {
    runBlocking {
        newTopic("Job")
        val job = launch {
            startMsg()
            delay(someTime())
            print("job...")
            endMsg()
        }
        println("Job: $job")

        // job.cancel()

        //   delay(4_000)
        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")
    }
}

fun cAsync() {
    runBlocking {
        newTopic("Async")

        val result = async {
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
