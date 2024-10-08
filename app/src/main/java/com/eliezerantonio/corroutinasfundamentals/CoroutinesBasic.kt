package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //globalScope()
    //suspendFun()
    //newTopic("Constructores de corrutinas")
    //cRunBlocking()
    //cLaunch()
    //cAsync()
    //job()
    //deferred()
    cProduce()

    readLine()
}

fun cProduce() = runBlocking{
    newTopic("Produce")
    val names = produceNames()
    names.consumeEach { println(it) }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceNames(): ReceiveChannel<String> = produce {
    (1..5).forEach { send("name$it") }
}

fun deferred() {
    runBlocking {
        newTopic("Deferred")
        val deferred = async {
            startMsg()
            delay(someTime())
            println("deferred...")
            endMsg()
            multi(5, 2)
            "Hola"
        }
        println("Deferred: $deferred")
        println("Valor do Deferred.await: ${deferred.await()}")

        val result = async {
            multi(3, 3)
        }.await()
        println("Result: $result")
    }
}

fun job() {
    runBlocking {
        newTopic("Job")
        val job = launch {
            startMsg()
            delay(2_100)
            println("job...")
            endMsg()
        }
        println("Job: $job")

        //delay(4_000)
        println("isActive: ${job.isActive}")
        println("isCancelled: ${job.isCancelled}")
        println("isCompleted: ${job.isCompleted}")

        delay(someTime())
        println("Tarefa cancelada o interrumpida")
        job.cancel()

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
            1
        }
        println("Result: ${result.await()}")
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
    newTopic("RunBlocking")
    runBlocking {
        startMsg()
        delay(someTime())
        println("runBlocking...")
        endMsg()
    }
}

fun suspendFun() {
    newTopic("Suspend")
    Thread.sleep(someTime())
    //delay(someTime())
    GlobalScope.launch { delay(someTime()) }
}

fun globalScope() {
    newTopic("Global Scope")
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("My corrutina")
        endMsg()
    }
}

fun startMsg() {
    println("Start corrutina -${Thread.currentThread().name}-")
}
fun endMsg() {
    println("Corrutina -${Thread.currentThread().name}- Finished")
}
