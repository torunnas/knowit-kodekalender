import java.lang.Math.pow

fun main() {
    var maxGifts = pow(10.0, 13.0).toLong()
    var leftOvers = mapOf(2019 to 1854803357L, 2020 to 2787141611L, 2021 to 1159251923L)
    var children = mapOf(2019 to 2424154637L, 2020 to 2807727397L, 2021 to 2537380333L)
    for (i in 1..2000) {
        println(i)
        var a = children[2019]!! * i + leftOvers[2019]!!
        if (a > maxGifts) {
            break
        }
        for (j in 1..2000) {
            var b = children[2020]!! * j + leftOvers[2020]!!
            if (b > maxGifts) {
                break
            }
            for (k in 1..2000) {
                var c = children[2021]!! * k + leftOvers[2021]!!
                if (c > maxGifts) {
                    break
                }
                if (a == b && b == c) {
                    println(a)
                    System.exit(0)
                }
            }
        }
    }
}