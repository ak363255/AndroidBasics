package com.example.androidinterview.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        joinAll(
            async {
                suspendcoroutine(1, 500)
            },
            async {
                suspendcoroutine(2, 300)
            },
            async{
                repeat(5){
                    println("other task is working on ${Thread.currentThread().name}")
                    delay(100)
                }
            }
        )

    }
}

suspend fun suspendcoroutine(number: Int, delay: Long) {
    println("routine $number starts Thread -${Thread.currentThread().name}")
    delay(delay)
    println("routine $number ends  Thread -${Thread.currentThread().name}")
}
