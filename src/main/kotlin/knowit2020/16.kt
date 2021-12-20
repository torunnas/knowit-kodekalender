package knowit2020

import org.apache.commons.math3.primes.Primes
import kotlin.math.floor
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    var res = 0
    var start = System.currentTimeMillis()
    var oStart = start
    //var oldPrimes = 0
    for (i in 2..1000000) {
        if (i % 100000 == 0) {
            println("$i = ${System.currentTimeMillis() - start}ms")
            start = System.currentTimeMillis()
        }
        var sum = sumOfDivisors(i)
        val sqrt = sqrt(sum.toDouble() - (2 * i))
        if (sum > 2 * i && ceil(sqrt) == floor(sqrt)) {
            res++
        }

    }
    println("Total ${System.currentTimeMillis() - oStart}ms")
    println(res)
}

//var primes = mutableSetOf<Int>()
//var high = 0

private fun sumOfDivisors(number: Int): Long {
    var factors = Primes.primeFactors(number).groupBy { it }
    return factors.map { (it.key.toDouble().pow(it.value.size + 1).toLong() - 1) / (it.key - 1) }
        .reduce { acc, a -> acc * a }
}


//    var factors = mutableMapOf<Int, Int>()
//    var rest = number
//    for (i in primes) {
//        if (rest % i == 0) {
//            if (i > 100000) {
//                high++
//            }
//            if (factors[i] == null) {
//                factors[i] = 0
//            }
//            while (rest % i == 0) {
//                factors[i] = factors[i]!! + 1
//                rest /= i
//            }
//        }
//        if (rest == 1) {
//            break
//        }
//    }