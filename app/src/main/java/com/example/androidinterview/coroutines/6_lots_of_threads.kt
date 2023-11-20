package com.example.androidinterview.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


fun main() {
    runBlocking {
        repeat(100000){
            thread {
                Thread.sleep(5000)
                print(".")
            }
        }

    }
}