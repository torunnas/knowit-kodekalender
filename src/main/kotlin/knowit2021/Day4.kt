import java.io.File
import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    var x = BigInteger.valueOf(6666666666666666666).times(BigInteger.valueOf(10))
    var y = (BigInteger.valueOf(3333333333333333333).times(BigInteger.valueOf(10))).plus(BigInteger.valueOf(3))
    var dx = BigInteger.valueOf(1)
    var dy = BigInteger.valueOf(0)
    while (x.plus(y) < (BigInteger.valueOf(100L)
            .times(BigInteger.valueOf(1000000000000000000L)).plus(BigInteger.valueOf(79)))
    ) {
        x += dx
        y += dy
        if (dy > BigInteger.ZERO
            && y.mod(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) == 0
            && y.mod(BigInteger.valueOf(5)).compareTo(BigInteger.ZERO) != 0
        ) {
            dy = BigInteger.ZERO
            dx = BigInteger.valueOf(1)
        } else if (dx > BigInteger.ZERO
            && x.mod(BigInteger.valueOf(5)).compareTo(BigInteger.ZERO) == 0
            && x.mod(BigInteger.valueOf(3)).compareTo(BigInteger.ZERO) != 0
        ) {
            dx = BigInteger.ZERO
            dy = BigInteger.valueOf(1)
        }
    }
    println("$x,$y")
}