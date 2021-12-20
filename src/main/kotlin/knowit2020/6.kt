package main.java.`2020`

import java.io.File

fun main() {
    var s = File("input2020/input6.txt").readLines()[0]
    var list = s.split(",").map { Integer.parseInt(it) }.toMutableList()
    list.sort()
    list.reverse()
    var elves = 127
    //var sum = list.sumBy { it }
    var sum = 0
    var count = 0
    var res = ""
    for (i in list) {
        sum += i
        count++
        if (sum % elves == 0) {
            res = "${sum/elves},$count"
        }
    }
    println(res)
}