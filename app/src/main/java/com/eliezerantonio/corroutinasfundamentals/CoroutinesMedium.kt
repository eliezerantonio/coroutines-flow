package com.eliezerantonio.corroutinasfundamentals

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking


fun main() {
    dispatchers()
}

@OptIn(DelicateCoroutinesApi::class)
fun dispatchers() {
    runBlocking {
        newTopic("Dispatchers")
        launch {
            startMsg()
            println("None")
            endMsg()
        }

        launch(Dispatchers.IO) {
            startMsg()
            println("None")
            endMsg()
        }

        launch(Dispatchers.Unconfined) {
            startMsg()
            println("Unconfined")
            endMsg()
        }

        // for android main and default

        launch(Dispatchers.Default) {
            startMsg()
            println("Default")
            endMsg()
        }

        launch(newSingleThreadContext("Android Course ")) {
            startMsg()
            println("My custom Coroutine with dispatcher")
            endMsg()

        }
        newSingleThreadContext(" CurdoAndroidANT").use { myContext ->
            launch(myContext) {
                startMsg()
                println("My custom Coroutine con un dispatcher2")
                endMsg()

            }
        }
    }
}
