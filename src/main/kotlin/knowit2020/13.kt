package main.java.`2020`

import java.io.File
import java.lang.StringBuilder

fun main() {
    //var list = mutableListOf<Int>()
    //File("input2020/input13.txt").forEachLine { list.add(it.toInt()) }
    var s = File("input2020/input13.txt").readLines()[0]
    //var list = s.split(",").map { it -> Integer.parseInt(it) }.toMutableList()
    var copy = s
    var remove = mutableListOf<Int>()
    for(c in 'a'..'z'){
        var count = 0
        for(i in s.indices){
            if(s[i]==c && count==c.toInt()-97){
                count++
            }
            else if(s[i]==c){
                remove.add(i)
                count++
            }

        }
    }
    var res = StringBuilder()
    for(i in s.indices){
        if(!remove.contains(i)){
            res.append(s[i])
        }
    }
    println(res.toString())
}