package knowit2020

import java.io.File

fun main() {
    var s = File("input2020/input1.txt").readLines()[0]
    var list = s.split(",").map { it -> Integer.parseInt(it) }.toMutableList()
    for(i in 1..100000){
        if(!list.contains(i)){
            println(i)
            break
        }
    }
}