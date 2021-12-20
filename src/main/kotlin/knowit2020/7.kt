package main.java.`2020`

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input7.txt").forEachLine { list.add(it) }
    var s = list[list.size - 1]
    var count = 0
    for (i in s.indices) {
        if (s[i] == '#') {
            if (checkTree(i, list)) {
                count++
            }
        }
    }
    println(count)
}

private fun checkTree(i: Int, list: MutableList<String>): Boolean {
    for (l in list) {
        if (i < l.length) {
            if (!checkNeighbours(i, l)) {
                return false
            }
        }
    }
    return true
}

fun checkNeighbours(i: Int, s: String): Boolean {
    var countR = 0
    var j = i + 1
    var k = i - 1
    var numBlanks = 0
    while(j < s.length && k > -1 && numBlanks<2){
        if(s[j] == ' ' && s[k] == ' '){
            numBlanks++
        }
        if(s[j]!=s[k]){
            return false
        }
        j++
        k--
    }
    return true
}
