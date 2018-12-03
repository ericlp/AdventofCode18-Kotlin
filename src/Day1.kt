import com.sun.org.apache.xpath.internal.operations.Bool
import java.io.File

fun main(args: Array<String>) {
    val input = parse("assets/day1.txt")
    part1Reddit(input)
}

private fun part1 (fileName: String) {

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

fun part1Reddit (input: List<Int>) {
    println(input.sum())
}

private fun part2 (input: List<Int>) {

    var result: Int = 0
    var set: MutableSet<Int> = mutableSetOf()

    while (true) {
        for (number in input) {
            if (!set.add(result)) {
                println(result)
                return
            }
            result += number
        }
    }
}

fun parse(input: String) = File(input).readLines().map(String::toInt)