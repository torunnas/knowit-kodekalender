package knowit2021

import java.io.File

fun main() {
    var line = File("input2021/input1.txt").readLines()[0]
    val sum = getSum(line)
    println(sum)
}

private fun getSum(input:String):Int{
    var left = input
    var sum = 0
    while(left.isNotEmpty()){
        when {
            left.startsWith("femti") -> { left = left.removePrefix("femti"); sum += 50 }
            left.startsWith("førti") -> { left = left.removePrefix("førti"); sum += 40 }
            left.startsWith("tretti") -> { left = left.removePrefix("tretti"); sum += 30 }
            left.startsWith("tjue") -> { left = left.removePrefix("tjue"); sum += 20 }
            left.startsWith("nitten") -> { left = left.removePrefix("nitten"); sum += 19 }
            left.startsWith("atten") -> { left = left.removePrefix("atten"); sum += 18 }
            left.startsWith("sytten") -> { left = left.removePrefix("sytten"); sum += 17 }
            left.startsWith("seksten") -> { left = left.removePrefix("seksten"); sum += 16 }
            left.startsWith("femten") -> { left = left.removePrefix("femten"); sum += 15 }
            left.startsWith("fjorten") -> { left = left.removePrefix("fjorten"); sum += 14 }
            left.startsWith("tretten") -> { left = left.removePrefix("tretten"); sum += 13 }
            left.startsWith("tolv") -> { left = left.removePrefix("tolv"); sum += 12 }
            left.startsWith("elleve") -> { left = left.removePrefix("elleve"); sum += 11 }
            left.startsWith("ti") -> { left = left.removePrefix("ti"); sum += 10 }
            left.startsWith("ni") -> { left = left.removePrefix("ni"); sum += 9 }
            left.startsWith("åtte") -> { left = left.removePrefix("åtte"); sum += 8 }
            left.startsWith("sju") -> { left = left.removePrefix("sju"); sum += 7 }
            left.startsWith("seks") -> { left = left.removePrefix("seks"); sum += 6 }
            left.startsWith("fem") -> { left = left.removePrefix("fem"); sum += 5 }
            left.startsWith("fire") -> { left = left.removePrefix("fire"); sum += 4 }
            left.startsWith("tre") -> { left = left.removePrefix("tre"); sum += 3 }
            left.startsWith("to") -> { left = left.removePrefix("to"); sum += 2 }
            left.startsWith("en") -> { left = left.removePrefix("en"); sum += 1 }
        }
    }
    return sum
}