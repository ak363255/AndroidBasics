package com.example.androidinterview.coroutines

import kotlin.concurrent.thread

fun main(){
    println("main starts")
    threadRoutine(1,500)
    threadRoutine(2,300)
    Thread.sleep(1000)
    println("main ends")
}
/*
Threads has some disadvantages when it comes to efficiency and performance
Thread consume considerable amount of memory and switching between threads is very expensive.
in coroutine  ex we are able to  achieve concurrent  behaviour without creating new thread and swithching
between them every thing is executed on the same thread.
 */
private fun threadRoutine(number:Int,delay:Long){
    thread {
        println("Routine $number starts work ${Thread.currentThread().name}")
        Thread.sleep(delay)
        println("Routine $number finished ${Thread.currentThread().name}" )
    }
}