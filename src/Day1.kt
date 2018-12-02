import com.sun.org.apache.xpath.internal.operations.Bool
import java.io.File

fun main(args: Array<String>) {
    part2("src/day1.txt")
}

fun part1 (fileName: String) {

    var result: Int = 0

    File(fileName).forEachLine {
        when (it[0]) {
            '-' -> result -= it.substring(1,it.length).toInt()
            '+' -> result += it.substring(1,it.length).toInt()
        }
        println(result)
    }
    println("the result is $result")
}

fun part2 (fileName: String) {

    var result: Int = 0
    var set: MutableSet<Int> = mutableSetOf()
    var twiceFreq: Int = 0
    var hasFoundFreq: Boolean = false

    while (!hasFoundFreq)
        File(fileName).forEachLine {
            if (!set.add(result) && !hasFoundFreq) {
                twiceFreq = result
                hasFoundFreq = true
            }
            when (it[0]) {
                '-' -> result -= it.substring(1, it.length).toInt()
                '+' -> result += it.substring(1, it.length).toInt()
            }
        }

    println("The first frequency found twice was $twiceFreq")
}