package knowit2020

import java.io.File

fun main() {
    val list = mutableListOf<String>()
    File("input2020/input20.txt").forEachLine { list.add(it) }
    val tree = "🎄"
    var elves = mutableListOf<List<String>>()
    val working = mutableSetOf<String>()
    for (a in list) {
        val hi = a.split(tree).map { it.trim() }.toList()
        elves.add(hi)
        working.add(hi.last())
    }

    elves = removeResigned(elves, elves.flatten().toSet() - working)
    val slaves = mutableMapOf<String, MutableSet<String>>()
    for (e in elves) {
        var last = ""
        for (a in e) {
            if (last.isNotEmpty()) {
                slaves[last] = (slaves.getOrDefault(last, mutableSetOf()) + a) as MutableSet<String>
            }
            last = a
        }
    }
    val fired =
        slaves.filter { it.value.size == 1 }.filter { slaves.containsKey(it.value.first()) }.map { it.key }
            .toSet()
    elves = removeResigned(elves, fired)
    val total = elves.flatten().toSet().count()
    val leaders = elves.flatMap { it.dropLast(1) }.toSet()
    val ans = total - leaders.size * 2
    println("$ans ${5845 == ans}")
}

private fun removeResigned(elves: MutableList<List<String>>, resigned: Set<String>): MutableList<List<String>> {
    return elves.map { val a = it.toMutableList(); a.removeAll(resigned); a.toList() }.toMutableList()
}