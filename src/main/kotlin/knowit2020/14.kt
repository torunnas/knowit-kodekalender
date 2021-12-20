package main.java.`2020`

import java.math.BigInteger
import org.apache.commons.math3.primes.Primes

fun main() {
    var start = System.currentTimeMillis()
    var list = mutableListOf(0, 1)
    var sum = 0
    var count = 2
    var seen = mutableSetOf(0, 1)
    while (count <= 1800813) {
        var res = list[0] - count
        if (res < 0 || res in seen) {
            res = list[0] + count
        }
        list.add(res)
        seen.add(res)
        if (Primes.isPrime(res)) {
            sum++
        }
        list.removeAt(0)
        count++
    }
    println(sum)
    println(System.currentTimeMillis()-start)
}