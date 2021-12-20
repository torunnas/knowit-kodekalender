package knowit2020

import java.io.File
import java.lang.StringBuilder

fun main() {
    val list = mutableListOf<String>()
    File("input2020/input22.txt").forEachLine { list.add(it) }
    var max = Pair(-1, 0)
    for (i in list.indices) {
        val split = list[i].split("[")
        var s = split[0].trim().toLowerCase()
        val names = split[1].split(",").map { it.replace("]", "") }.map { it.trim().toLowerCase() }
        var count = 0
        for (name in names) {
            val indices = findName(name, s)
            if (indices.size == name.length) {
                s = removeIndices(s, indices)
                count++

            }
        }
        if (count > max.second) {
            max = Pair(i, count)
        }
    }
    println("${max.first} $max ${max == Pair(688, 16)}")
}

private fun findName(name: String, s: String): Set<Int> {
    var j = 0
    val indices = mutableSetOf<Int>()
    for (c in name) {
        for (b in j until s.length) {
            if (s[b] == c) {
                indices.add(b)
                j = b + 1
                break
            }
        }
    }
    return indices
}

private fun removeIndices(s: String, indices: Set<Int>): String {
    val newS = StringBuilder()
    for (k in s.indices) {
        if (!indices.contains(k)) {
            newS.append(s[k])
        }
    }
    return newS.toString()
}