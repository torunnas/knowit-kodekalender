package knowit2020

import java.io.File

fun main() {
    var input = File("input2020/input24.txt").readLines()[0]
    var count = 10
    var houses = 0
    for (i in input) {
        if (i == '1') {
            count += 2
        } else if (count == 0) {
            println(houses)
            println(houses == 3333490)
            System.exit(0)
        }
        count--
        houses++
    }
}