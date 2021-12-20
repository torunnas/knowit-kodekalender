package main.java.`2020`

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input10.txt").forEachLine { list.add(it) }
    var map  = mutableMapOf<String,Int>()
    for(s in list){
        val comp = s.split(",").toMutableList()
        var p =1
        for(c in comp){
            if(map[c.trim()] == null){
                map[c.trim()] = 0
            }
            map[c.trim()] =  map[c.trim()]!!+ comp.size-p
            p++
        }
    }
    println(map.maxBy { it.value })
}