package knowit2020

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input19.txt").forEachLine { list.add(it) }
    val games = mutableListOf<Game>()
    for (a in list) {
        val split = a.split('[').map { it.trim() }
        val splitn = split[0].split(' ').map { it.trim() }
        val elves = split[1].split(',').map { it.replace("]", "").trim() }.toMutableList()
        games.add(Game(splitn[0].toInt(), splitn[1].toInt(), elves))
    }
    val wins = mutableMapOf<String, Int>()
    for (g in games) {
        val winner = playGame(g)
        wins.inc(winner)
    }
    val overAllWinner = wins.maxBy { it.value }
    println(overAllWinner)
    println("Spencer" == overAllWinner?.key)
}

fun <T> MutableMap<T, Int>.inc(key: T, value: Int = 1) = merge(key, value, Int::plus)

fun playGame(g: Game): String {
    var j = 0
    while (g.elves.size > 1) {
        var new = g.elves.toMutableList()
        for (i in g.elves.indices) {
            new[(i + g.step) % g.elves.size] = g.elves[i]
        }
        when (g.rule) {
            1 -> {
                new.removeAt(0)
            }
            2 -> {
                new.removeAt(j)
                j = (j + 1) % new.size
            }
            3 -> {
                if (new.size == 2) {
                    new.removeAt(0)
                } else if (new.size % 2 == 0) {
                    new.removeAt(new.size / 2)
                    new.removeAt(new.size / 2)
                } else {
                    new.removeAt(new.size / 2)
                }
            }
            4 -> {
                new = new.dropLast(1).toMutableList()
            }
        }
        g.elves = new
    }
    return g.elves[0]
}

data class Game(val rule: Int, val step: Int, var elves: MutableList<String>)