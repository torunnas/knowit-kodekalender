import java.io.File

fun main() {
    var lines = File("input2021/input8.txt").readLines()
    var cities = mutableListOf<Pair<Int, Int>>()
    var list = mutableListOf<Int>()
    for (line in lines) {
        if (line.startsWith("(")) {
            val split = line.removeSuffix(")").removePrefix("(").split(",").map { it.trim().toInt() }
            cities.add(Pair(split[0], split[1]))
        } else {
            list.add(line.trim().toInt())
        }
    }
    var packets = mutableMapOf<Pair<Int, Int>, Int>()
    var a = Pair(-1, -1)
    var b = Pair(-1, -1)
    for (i in list) {
        if (a.first == -1) {
            a = cities[i]
            continue
        }else if(b.first == -1){
            b = cities[i]
        } else {
            a = b
            b = cities[i]
        }
        if (a.first < b.first) {
            if (a.second < b.second) {
                for(x in a.first..b.first-1){
                    for(y in a.second..b.second-1){
                        val current = packets.getOrDefault(Pair(x, y), 0)
                        packets[Pair(x,y)] = current + 1
                    }
                }
            } else {
                for(x in a.first..b.first-1){
                    for(y in b.second+1..a.second){
                        val current = packets.getOrDefault(Pair(x, y), 0)
                        packets[Pair(x,y)] = current + 1
                    }
                }
            }
        } else {
            if (a.second < b.second) {
                for(x in b.first+1..a.first){
                    for(y in a.second..b.second-1){
                        val current = packets.getOrDefault(Pair(x, y), 0)
                        packets[Pair(x,y)] = current + 1
                    }
                }
            } else {
                for(x in b.first+1..a.first){
                    for(y in b.second+1..a.second){
                        val current = packets.getOrDefault(Pair(x, y), 0)
                        packets[Pair(x,y)] = current + 1
                    }
                }
            }
        }
    }
    val maxBy = packets.maxBy { it.value }!!.value
    println(packets.filter { it.value == maxBy })
}