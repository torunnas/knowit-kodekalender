import java.io.File

fun main() {
    var line = File("input2021/input3.txt").readLines()[0]
    var maxIndex = 0
    var maxValue = 0
    for (i in line.indices) {
        for (j in line.substring(i).indices) {
            val substring = line.substring(i..i + j)
            val countJ = substring.count { it == 'J' }
            val countN = substring.count { it == 'N' }
            if (countJ == countN && countJ + countN > maxValue) {
                maxValue = countJ + countN
                maxIndex = i
            }
        }
    }
    println("$maxValue, $maxIndex")
}