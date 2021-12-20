package knowit2020

import java.io.File
import java.lang.StringBuilder

fun main() {
    var start = System.currentTimeMillis()
    var list = mutableListOf<String>()
    File("input2020/input17.txt").forEachLine { list.add(it) }
    var floor = list
    var vac = getVac()
    var brush = getBrush()
    for (j in list.indices) {
        for (i in list[j].indices) {
            if (space(j, i, list, vac)) {
                floor = vacuum(j, i, floor, brush)
            }
        }
    }
    var res = floor.sumBy { it.count { it == ' ' } }
    println(res)
    println(res == 288903)
    println("${System.currentTimeMillis() -start}ms")

}

fun vacuum(j: Int, i: Int, floor: MutableList<String>, brush: MutableMap<Int, List<IntRange>>): MutableList<String> {
    var new = floor
    for (y in brush.keys) {
        for (x in brush[y]!!.flatten()) {
            if (j + y !in floor.indices || i + x !in floor[j + y].indices) {

            } else if (floor[j + y][i + x] == ' ') {
                val s = StringBuilder(floor[j + y])
                s.setCharAt(i + x, 's')
                new[j + y] = s.toString()
            }
        }
    }
    return new
}

fun space(j: Int, i: Int, list: MutableList<String>, vac: MutableMap<Int, IntRange>): Boolean {
    for (y in vac.keys) {
        for (x in vac[y]!!) {
            if (j + y !in list.indices || i + x !in list[j + y].indices) {
                return false
            }
            if (list[j + y][i + x] == 'X' || list[j + y][i + x] == 'x') {
                return false
            }
        }
    }
    return true
}

private fun getVac(): MutableMap<Int, IntRange> {
    var vac = mutableMapOf<Int, IntRange>()
    vac[0] = -3..3
    vac[1] = -3..3
    vac[2] = -2..2
    vac[3] = -1..1
    vac[-1] = -3..3
    vac[-2] = -2..2
    vac[-3] = -1..1
    return vac
}

private fun getBrush(): MutableMap<Int, List<IntRange>> {
    var vac = mutableMapOf<Int, List<IntRange>>()
    vac[0] = listOf(-3..3)
    vac[1] = listOf(-3..3)
    vac[2] = listOf(-4..4)
    vac[3] = listOf(-4..4)
    vac[4] = listOf(-4..-2, 2..4)
    vac[-1] = listOf(-3..3)
    vac[-2] = listOf(-4..4)
    vac[-3] = listOf(-4..4)
    vac[-4] = listOf(-4..-2, 2..4)

    return vac
}
