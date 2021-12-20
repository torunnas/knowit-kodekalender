package main.java.`2020`

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input4.txt").forEachLine { list.add(it) }
    var ing = mutableListOf<String>()
    for(s in list){
        s.split(",").forEach{ing.add(it)}
    }
    var sugar = 0L
    var flour = 0L
    var milk = 0L
    var egg = 0L
    for(i in ing){
        val split = i.split(":")
        val word = split[0].trim()
        val value = split[1].trim().toInt()
        if(word == "sukker"){
            sugar += value
        }
        else if(word == "mel"){
            flour += value
        }
        if(word == "melk"){
            milk += value
        }
        if(word == "egg"){
            egg += value
        }
    }
    var s = sugar/2
    var f = flour/3
    var m = milk/3
    var e = egg

    println(listOf(s,f,m,e).min())
}