import java.io.File

fun main() {
    var line = File("input2021/input5.txt").readLines()[0]
    while (line.contains("Grinch")) {
        val start = line.indexOf("Grinch")
        var open = 0
        var first = true
        var i = start
        while (first || open != 0) {
            val c = line[i]
            if (c == '(') {
                open++
                first = false
            } else if (c == ')') {
                open--
            }
            i++
        }
        var end = i
        line = line.removeRange(start until end)
    }
    var max = 0
    var count = 0
    for (i in line.indices) {
        if (line[i] == '(') {
            count++
            if (count > max) {
                max = count
            }
        } else if (line[i] == ')') {
            count--
        }
    }
    println(max)
}