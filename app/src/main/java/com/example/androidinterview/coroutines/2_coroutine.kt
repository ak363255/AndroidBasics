package com.example.androidinterview.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
        println("main starts")

        joinAll(
            async { coroutine(1,1000) } ,
            async { coroutine(2,500) }
        )
        println("main ends")
    }
/*
output are :-

main starts
routine 1 starts Thread -main
routine 2 starts Thread -main
routine 2 ends  Thread -main
routine 1 ends  Thread -main
main ends

As we can see routine 2 start and even finished before routine 1
lets analyze what happened
here our main function that calls our two coroutine function sequentially
first coroutine function is invoked it only executes the first print statement.
then return the control flow to main function.
then main function executes second print statement of routine 2
then return the control flow to main function
after 500 milli seconds kotlin coroutine machinery print second print statement from routine 2
after 1000 milli seconds kotlin coroutine machinery print second print statement from routine 1.

what we can see here is coroutine can pass the control flow back forth between each other.


 */
    suspend fun coroutine(number:Int,delay:Long){
        println("routine $number starts Thread -${Thread.currentThread().name}")
        delay(delay)
        println("routine $number ends  Thread -${Thread.currentThread().name}")
    }

