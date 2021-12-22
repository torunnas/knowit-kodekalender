import kotlin.math.abs

fun main() {
    val board = Array(3) { IntArray(3) }
    println(travel(board, Pair(1, 0), 1))
}

private fun travel(board: Array<IntArray>, current: Pair<Int, Int>, depth: Int): Int {
    if (depth == 8) {
        return 1
    }
    var boardcopy = board.copy()
    val list = listOf(0 to 0, 0 to 2, 2 to 0, 2 to 2)
    var count = 0
    var x = current.first
    var y = current.second
    boardcopy[x][y] = 1
    for (i in -2..2) {
        for (j in -2..2) {
            if (!(x + i in 0..2 && y + j in 0..2)) continue
            var dx= x+i
            var dy= y +j
            val i1 = boardcopy[x + i][y + j]
            if (boardcopy[x + i][y + j] != 1) {
                if ((current.first == x + i && abs(current.second - (y + j)) == 2)){
                    if (boardcopy[current.first][1] == 1){
                        count += travel(boardcopy, Pair(x + i, y + j), depth + 1)
                    }
                }
                else if((current.second == y + j && abs(current.first - (x + i)) == 2)){
                    if (boardcopy[1][current.second] == 1){
                        count += travel(boardcopy, Pair(x + i, y + j), depth + 1)
                    }
                }
                else if (list.contains(current) && list.contains(Pair(x + i, y + j)))
                {
                    if (boardcopy[1][1] == 1){
                        count += travel(boardcopy, Pair(x + i, y + j), depth + 1)
                    }
                } else {
                    count += travel(boardcopy, Pair(x + i, y + j), depth + 1)
                }
            }

        }
    }
    return count
}

fun Array<IntArray>.copy() = map { it.clone() }.toTypedArray()