fun main() {
    var posSanta = 20.0
    var posAnt = 1.0
    while (posSanta > posAnt) {
        var newPosSante = posSanta + 20.0
        var factor = newPosSante/posSanta
        posAnt = (posAnt*factor) + 1.0
        posSanta = newPosSante
    }
    println(posSanta.toLong()/100)
}