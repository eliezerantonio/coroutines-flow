package com.eliezerantonio.corroutinasfundamentals

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {

    lambda()
    threads()
}

fun threads() {
    println("Thread ${multiThread(2, 3)}")
    multiThreadLambda(2,3){
        print("Thread Lambda $it")
    }
}


fun multiThread(x: Int, y: Int): Int {
    var result = 0

    //background task
    thread {
        Thread.sleep(someTime())
        result = x * y

    }
    Thread.sleep(2_100)
    return result

}
fun multiThreadLambda(x: Int, y: Int, callback: (result: Int)-> Unit) {
    var result = 0

    //background task
    thread {
        Thread.sleep(someTime())
        result = x * y
        callback(result)
    }


}


fun someTime(): Long = Random.nextLong(500, 2_000)


fun lambda() {
    println(multi(2, 3))

    multiLambda(3, 2) { result ->
        println(result)
    }

}

fun multiLambda(x: Int, y: Int, callback: (result: Int) -> Unit) {
    callback(x * y)

}

fun multi(x: Int, y: Int): Int {

    return x * y

}
