package main.java.`2020`

import java.io.File
import java.lang.StringBuilder

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input9.txt").forEachLine { list.add(it) }
    var yesterday = list
    var today = mutableListOf<String>()
    var changed = true
    var day = 0L
    while (changed) {
        changed = false
        for (i in yesterday.indices) {
            var todayString = StringBuilder()
            for (j in yesterday[i].indices) {
                var count = 0
                if (i - 1 > 0 && yesterday[i - 1][j] == 'S') {
                    count++
                }
                if (i + 1 < yesterday.size && yesterday[i + 1][j] == 'S') {
                    count++
                }
                if (j - 1 > 0 && yesterday[i][j - 1] == 'S') {
                    count++
                }
                if (j + 1 < yesterday[i].length && yesterday[i][j + 1] == 'S') {
                    count++
                }
                if (count > 1 && yesterday[i][j] == 'F') {
                    changed = true
                    todayString.append("S")
                }
                else{
                    todayString.append(yesterday[i][j])
                }
            }
            today.add(todayString.toString())
        }
        day++
        yesterday = today
        today = mutableListOf()
    }
    println(day)
}