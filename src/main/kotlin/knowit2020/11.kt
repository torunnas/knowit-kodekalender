package main.java.`2020`

import java.io.File

val goal = "eamqia"

fun main() {
    var list = mutableListOf<String>()
    File("input2020/input11.txt").forEachLine { list.add(it) }
    for (s in list) {
        if(password(s)){
            println(s)
            break
        }
    }
}

fun password(s: String): Boolean {
    var list = mutableListOf<String>()
    list.add(s)
    var last = s
    while (last.length > 1) {
        var drop = last.drop(1)
        var h = StringBuilder()
        for(d in drop){
            if(d=='z'){
                h.append('a')
            }
            else{
                h.append(d+1)
            }
        }
        var new = h.toString()
        var k = StringBuilder()
        for (n in new.indices) {
            if (new[n] + last[n].toInt()-97 > 'z'){
                k.append(new[n] + last[n].toInt()-97-26)
            }
            else{
                k.append(new[n] + last[n].toInt()-97)
            }
        }
        list.add(k.toString())
        last = k.toString()
    }
    var passwords = mutableListOf<String>()
    for(i in s.indices){
        var p = StringBuilder()
        for(l in list){
            if(i>=l.length){
                break
            }
            else{
                p.append(l[i])
            }
        }
        passwords.add(p.toString())
    }
    for(p in passwords){
        if(p.contains(goal)){
            return true
        }
    }
    return passwords.contains(goal)
}
