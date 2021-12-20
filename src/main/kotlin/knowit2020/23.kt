package knowit2020

import java.io.File

val vowls = setOf('a', 'e', 'i', 'o', 'u', 'y', 'æ', 'ø', 'å')
var baseWords = mutableMapOf<String, Int>()

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input23-1.txt").forEachLine { list.add(it.trim()) }
    for (a in list) {
        val split = a.split(" ")
        baseWords[split[0].trim()] = split[1].trim().toInt()
    }
    list = mutableListOf<String>()
    File("input2020/input23-2.txt").forEachLine { list.add(it.trim()) }
    val result = mutableMapOf<String, Int>()
    for (i in list.indices) {
        val split = list[i].split(":")
        val name = split[0].trim()
        val words = split[1].trim().split(" ").map { it.trim() }
        result[name] = result.getOrDefault(name, 0) + points(words)
    }
    val winner = result.maxBy { it.value }!!
    println("${winner.key},${winner.value}")
    println("${winner.key=="Nizzy G"},${winner.value==3316}")
}

private fun points(words: List<String>): Int {
    var lastWord = ""
    var occ = 1
    var sum = 0
    for (word in words) {
        var value = 0
        var bonus = 0
        var baseWord = word.removePrefix("jule")
        if (baseWords.contains(baseWord)) {
            value = baseWords[baseWord]!!
        }
        val diff = word.count { vowls.contains(it) } - lastWord.count { vowls.contains(it) }
        if (diff > 0 && lastWord != "") {
            bonus = diff
            if (word.startsWith("jule")) {
                bonus *= 2
            }
        }
        if (lastWord.removePrefix("jule") == baseWord) {
            occ++
        } else {
            occ = 1
        }
        lastWord = word
        sum += (value + bonus) / occ
    }
    return sum
}