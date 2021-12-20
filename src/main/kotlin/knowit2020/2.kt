package knowit2020

fun main() {
    var i = 0
    var count = 0;
    while(i<=5433000){
        if(i.toString().contains("7")){
            i+=closestPrime(i)
        }
        else{
            count++
        }
        i++
    }
    println(count)
}

private fun closestPrime(n:Int):Int{
    if(isPrimeNo(n)){
        return n
    }
    var i = n
    while(true){
        i--
        if(isPrimeNo(i)){
            return i
        }

    }
}

fun isPrimeNo(number: Int): Boolean {
    if(number<2) return false
    for (i in 2..number/2) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}