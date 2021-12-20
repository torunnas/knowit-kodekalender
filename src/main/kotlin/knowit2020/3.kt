package main.java.`2020`

import java.io.File

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input3-1.txt").forEachLine { list.add(it) }
    var words = mutableListOf<String>()
    File("input2020/input3-2.txt").forEachLine { words.add(it) }
    var found = mutableSetOf<String>()
    for (w in words) {
        var c = 0
        for (i in list.indices) {
            for (j in list[i].indices) {
                if (list[i][j] == w[c]) {
                    if (search(list, i, j, w, 1, 1,1)) {
                        found.add(w)
                    }
                    else if(search(list, i, j, w, -1, -1,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, 1, 0,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, 0, 1,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, 1, -1,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, -1, 1,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, -1, 0,1)){
                        found.add(w)
                    }
                    else if(search(list, i, j, w, 0, -1,1)){
                        found.add(w)
                    }
                }
            }
        }
    }
    println(words-found)
}

private fun search(list: List<String>, x: Int, y: Int, word: String, dirx: Int, diry: Int, letterindex:Int): Boolean {
    if(x+dirx<0 || x+dirx >= list.size || y+diry< 0 || y+diry >= list[x+dirx].length){
        return false
    }
    if(letterindex>=word.length-1){
        return true
    }
    if (list[x+dirx][y+diry] == word[letterindex]) {
        if (search(list, x+dirx, y+diry, word, dirx, diry,letterindex+1)) {
            return true
        }
    }
    return false
}