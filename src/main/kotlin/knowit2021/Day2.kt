import java.io.File
import kotlin.math.*

fun main() {
    val lines = File("input2021/input2.txt").readLines()
    val points = mutableSetOf<Pair<Double, Double>>()
    for (line in lines.drop(1)) {
        val split = line.split("Point(")[1].removeSuffix(")").split(" ").map { it.trim().toDouble() }
        points.add(Pair(split[0], split[1]))
    }

    val distance = findDistanceTraveled(points)
    println(distance)
}

private fun findDistanceTraveled(points: MutableSet<Pair<Double, Double>>): Long {
    val northPole = Pair(0.0, 90.0)
    val visited = mutableSetOf<Pair<Double, Double>>()
    var current = northPole
    var sum = 0.0
    while (visited.size < points.size) {
        val shortest = findShortest(current, points, visited)
            visited.add(shortest.first)
        sum += shortest.second
        current = shortest.first
    }
    val d = getDistance(current.first, current.second, northPole.first, northPole.second)
    sum += d
    return round(sum).toLong()
}

fun findShortest(
    current: Pair<Double, Double>,
    points: MutableSet<Pair<Double, Double>>,
    visited: MutableSet<Pair<Double, Double>>
): Pair<Pair<Double, Double>, Double> {
    val toCheck = points.filter { !visited.contains(it) }
    var minValue = Double.MAX_VALUE
    var minPoint = Pair(0.0, 0.0)
    for (point in toCheck) {
        val distance = getDistance(current.first, current.second, point.first, point.second)
        if (distance < minValue) {
            minValue = distance
            minPoint = point
        }
    }

    return Pair(minPoint, minValue)
}

private fun getDistance(e1: Double, n1: Double, e2: Double, n2: Double): Double{
    val radius = 6371
    val east1 = Math.toRadians(e1)
    val north1 = Math.toRadians(n1)
    val east2 = Math.toRadians(e2)
    val north2 = Math.toRadians(n2)
    return Math.toDegrees(
        acos(
            (cos(north1) * cos(north2) * cos(east1) * cos(east2) +
                    cos(north1) * sin(east1) * cos(north2) * sin(east2) +
                    sin(north1) * sin(north2))
        )
    )*(2 * Math.PI * radius / 360)
//    val a = sin((north2 - north1) / 2) * sin((north2 - north1) / 2) + cos(north1) * cos(north2) * sin((east2 - east1) / 2) * sin((east2 - east1) / 2)
//    val c = 2 * atan2(sqrt(a), sqrt(1-a))
//    return radius*c
}