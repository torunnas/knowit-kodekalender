package main.java.`2020`

import java.io.File

var visited = mutableSetOf<String>()
var tempvisited = mutableSetOf<String>()
fun main() {
    var s = File("input2020/input5.txt").readLines()[0]
    var m = Array(1000) { Array(1000) { 0 } }
    var list = mutableListOf<String>()
    var wallCoordinates = mutableListOf<Pair<Int, Int>>()
    var x = 500
    var y = 500
    var lastdir = 'N'
    var last = ' '
    wallCoordinates.add(Pair(x,y))
    for (c in s) {
        if (c == 'H') {
            x++
        } else if (c == 'V') {
            x--
        } else if (c == 'O') {
            y++
        } else if (c == 'N') {
            y--
        }
        m[x][y]=1
        wallCoordinates.add(Pair(x,y))

    }
    for (r in m.indices) {
        println(m[r].contentToString())
    }
    var a = x
    var b = y
    var area = 0
    var largest = 0
    for (i in 0..998) {
        for (j in 0..998) {
            if(!visited.contains("${i},${j}") && wallCoordinates.contains(Pair(i,j))&&wallCoordinates.contains(Pair(i+1,j))){
                visited.add("${i},${j}")
                var count = 0
                for(k in j+1..999){
                    if(wallCoordinates.contains(Pair(i,k))&&wallCoordinates.contains(Pair(i+1,k))){
                        visited.add("${i},${k}")
                        count += k-j
                        break
                    }
                }
                area +=count
                println(count)
            }
//            if (m[i][j] == 0 && !visited.contains("${i},${j}")) {
//                visited.add("${i},${j}")
//                val visit = visit(m, i, j)
//                area += visit
//                println(visit)
//                if (visit > largest) {
//                    largest = visit
//                }
//            }
        }
    }
    //area -= largest
    println(area)
    //visited.add("$a,$b")
    // area += visit(m , a,b)
    //println(s.length-area*3)


}

private fun visit(
    m: Array<Array<Int>>,
    x: Int,
    y: Int
): Int {
    if (m[x][y] != 0) {
        return 0
    }
    var sum = 1
    if (x + 1 < m.size && m[x + 1][y] == 0 && !visited.contains("${x + 1},${y}")) {
        visited.add("${x + 1},${y}")
        sum += visit(m, x + 1, y)
    }
    if (x - 1 > 0 && m[x - 1][y] == 0 && !visited.contains("${x - 1},${y}")) {
        visited.add("${x - 1},${y}")
        sum += visit(m, x - 1, y)
    }
    if (y + 1 < m.size && m[x][y + 1] == 0 && !visited.contains("${x},${y + 1}")) {
        visited.add("${x},${y + 1}")
        sum += visit(m, x, y + 1)
    }
    if (y - 1 > 0 && m[x][y - 1] == 0 && !visited.contains("${x},${y - 1}")) {
        visited.add("${x},${y - 1}")
        sum += visit(m, x, y - 1)
    }
    return sum

}
