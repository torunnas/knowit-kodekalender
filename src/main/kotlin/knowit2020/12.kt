package main.java.`2020`

import java.io.File

fun main() {
    var s = File("input2020/input12.txt").readLines()[0]
    var depth = 0
    var map = mutableMapOf<Int, Int>()
    for (i in s) {
        if (i == '(') {
            depth++
        } else if (i == ')') {
            depth--
        } else if (i.isUpperCase()) {
            if (map[depth] == null) {
                map[depth] = 0
            }
            map[depth] = map[depth]!! + 1
        }
    }
    println(map.maxBy { it.value })
}