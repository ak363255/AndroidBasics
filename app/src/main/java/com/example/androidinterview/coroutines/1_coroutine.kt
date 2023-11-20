package com.example.androidinterview.coroutines

fun main(){
    println("main starts")
    routine(1,1000)
    routine(2,1000)
    println("main ends")
}
private fun routine(number:Int,delay:Long){
    println("Routine $number starts work")
    Thread.sleep(delay)
    println("Routine $number finished")
}