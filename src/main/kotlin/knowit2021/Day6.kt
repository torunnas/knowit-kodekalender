import java.io.File

fun main() {
    var lines = File("input2021/input6.txt").readLines()
    val packets = mutableListOf<Pair<Int,Int>>()
    for(line in lines){
        val split = line.split(",").map { it.trim().toInt() }
        packets.add(Pair(split[0], split[1]))
    }
    var positionsHeight = mutableMapOf<Int, Int>()
    var count = 0
    for(packet in packets){
        if(positionsHeight.isEmpty()){
            for(i in packet.first until(packet.second+packet.first)){
                var current = positionsHeight.getOrDefault(i, 0)
                positionsHeight[i] = current + 1
            }
        }
        else{
            var highest = 0
             for(i in packet.first until (packet.second+packet.first)){
                 if(positionsHeight.getOrDefault(i,0) > highest){
                     highest = positionsHeight.getOrDefault(i,0)
                 }
             }
            if(positionsHeight[packet.first] == highest && positionsHeight[packet.second+packet.first-1] == highest){
                for(i in packet.first until (packet.second+packet.first)){
                    positionsHeight[i] = highest + 1
                }
            }
            else {
                var outside = 0
                var fallen = false
                for(i in packet.first until (packet.second + packet.first)){
                    if(positionsHeight.getOrDefault(i,0)<highest){
                        outside++
                    }
                    else{
                        break
                    }
                    if(outside >= (packet.second+1)/2){
                        count++
                        fallen = true
                        break
                    }
                }
                if(!fallen){
                    outside = 0
                    fallen = false
                    for(i in (packet.second + packet.first - 1) downTo packet.first){
                        if(positionsHeight.getOrDefault(i,0)<highest){
                            outside++
                        }
                        else{
                            break
                        }
                        if(outside >= ((packet.second+1)/2)){
                            count++
                            fallen = true
                            break
                        }
                    }
                }
                if(!fallen){
                    for(i in packet.first until (packet.second+packet.first)){
                        positionsHeight[i] = highest + 1
                    }
                }

            }
        }

    }

    println(count)
}