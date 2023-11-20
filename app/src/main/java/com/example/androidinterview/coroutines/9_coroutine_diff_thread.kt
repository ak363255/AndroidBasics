package com.example.androidinterview.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {
             CoroutineScope(Dispatchers.IO).launch{
                delay(5000)
                println("work finished ${Thread.currentThread().name}")
            }.join()
    }
    repeat(5){
        println("Main is not working ${Thread.currentThread().name}")
    }
}

suspend fun suspendcoroutinewithDispatcher(number: Int, delay: Long) {
    println("routine $number starts Thread -${Thread.currentThread().name}")
    delay(delay)
    withContext(Dispatchers.Default){
        println("routine $number ends  Thread -${Thread.currentThread().name}")
    }
}