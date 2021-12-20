package main.java.`2020`

import java.io.File
import kotlin.math.abs

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input8.txt").forEachLine { list.add(it) }
    var i = 0
    var cities = mutableListOf<City>()
    var visits = mutableListOf<String>()
    while (list[i].contains(":")) {
        val split = list[i].split(":")
        val name = split[0].trim()
        val coordinates = split[1].trim()
        val csplit = coordinates.split(",")
        val x = csplit[0].trim().drop(1).toInt()
        val y = csplit[1].trim().dropLast(1).toInt()
        cities.add(City(name, x, y))
        i++
    }
    for (j in i until list.size) {
        visits.add(list[j])
    }
    var x = 0
    var y = 0
    for (v in visits) {
        val city = getCity(v, cities)
        if (city.x == x && city.y == y) {
            continue
        }
        if (x < city.x) {
            for (k in x + 1..city.x) {
                x = k
                move(x, y, cities)
            }
        } else {
            for (k in x - 1 downTo city.x) {
                x = k
                move(x, y, cities)
            }
        }
        if (y < city.y) {
            for (k in y + 1..city.y) {
                y = k
                move(x, y, cities)
            }
        } else {
            for (k in y - 1 downTo city.y) {
                y = k
                move(x, y, cities)
            }
        }
    }
    val max = cities.maxBy { it.seconds }?.seconds
    val min = cities.minBy { it.seconds }?.seconds
    if (max != null && min != null) {
        println(max - min)
    }

}

fun move(x: Int, y: Int, cities: MutableList<City>) {
    for (c in cities) {
        val distance = abs(x - c.x) + abs(y - c.y)
        if (distance == 0) {
            c.seconds += 0
        } else if (distance < 5) {
            c.seconds += 0.25
        } else if (distance < 20) {
            c.seconds += 0.5
        } else if (distance < 50) {
            c.seconds += 0.75
        } else {
            c.seconds += 1
        }
    }
    print("")
}

fun getCity(name: String, cities: List<City>): City {
    for (c in cities) {
        if (c.name == name) {
            return c
        }
    }
    return City("", 0, 0)
}

data class City(val name: String, val x: Int, val y: Int, var seconds: Double = 0.toDouble())