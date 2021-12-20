package knowit2020

import java.io.File

fun main() {
    var start = System.currentTimeMillis()
    val dictionary = mutableSetOf<String>()
    File("input2020/input15-1.txt").forEachLine { dictionary.add(it.trim()) }
    val list = mutableSetOf<String>()
    File("input2020/input15-2.txt").forEachLine { list.add(it) }
    var words = mutableSetOf<String>()
    for (a in list) {
        val split = a.split(",")
        val first = split[0].trim()
        val second = split[1].trim()
        if (first !in dictionary || second !in dictionary) {
            continue
        }
        for (d in dictionary) {
            if (d in words) {
                continue
            }
            if (dictionary.contains(first + d) && dictionary.contains(d + second)) {
                words.add(d)
            }
        }
    }
    println(words.sumBy { it.length })
    println("" + (System.currentTimeMillis() - start) + "ms")
}