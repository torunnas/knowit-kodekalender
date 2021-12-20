package knowit2020

import java.io.File
import kotlin.math.ceil

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input18.txt").forEachLine { list.add(it) }
    //list= mutableListOf("gnisning","kauka","baluba", "tarotkorta")
    var sum = 0L
    for (a in list) {
        if (a.length == 2 || a == a.reversed()) {
            continue
        }
        var found = true
        var i = 0
        //println("${a.length}  ${ceil(a.length / 2.0) - 2}")
        while (i < ceil(a.length / 2.0) - 1) {
//           println(a.substring(i, i+2) )
//           println(a.reversed().substring(i,i+2).reversed())
            if (a[i] == a.reversed()[i]) {
                i++
                continue
            } else if (a.substring(i, i + 2) == a.reversed().substring(i, i + 2).reversed()) {
                i++
            } else {
                found = false
            }
            i++
        }
        if (found) {
            sum++
        }
    }
    println(sum)
    println(252L==sum)
}