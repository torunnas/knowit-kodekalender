package knowit2020

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input21.txt").forEachLine { list.add(it) }
    val queue = mutableMapOf<Int, List<String>>()
    var count = 0
    var next = ""
    var i = 0
    while (next != "Claus") {
        var a = list.getOrNull(i)
        if (a.isNullOrEmpty() || a.startsWith("-")) {
            next = removeFromQueue(queue)
            count++
        } else {
            val split = a.split(",").map { it.trim() }
            queue[split[1].toInt()] = queue[split[1].toInt()].orEmpty() + split[0]
        }
        i++
    }
    count-- //remove Claus
    println("$count ${count == 557}")
}

private fun removeFromQueue(queue: MutableMap<Int, List<String>>): String {
    for (i in 1..5) {
        if (!queue[i].isNullOrEmpty()) {
            var next = queue[i]?.first().orEmpty()
            queue[i] = queue[i]?.drop(1).orEmpty()
            return next
        }
    }
    return ""
}