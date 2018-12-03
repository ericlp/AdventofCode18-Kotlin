import java.io.File

fun main(args: Array<String>) {
    val lines = File("assets/day2.txt").readText().split("\n")
    part1(lines)
}

private fun part1 (lines: List<String>) {

    var has2 = false
    var has3 = false

    var check2 = 0
    var check3 = 0

    var map: MutableMap<Char,Int> = HashMap()

    var freq: Int?

    for (str in lines) {
        for (chr in str) {
            freq = map.put(chr, map.getOrDefault(chr, 0) + 1)
            when (freq) {
                1 -> if (!has2) {has2 = true; check2++}
                2 -> if (!has3) {has3 = true; check3++}
            }
        }
        has2 = false
        has3 = false
        map.clear()
    }

    println("The result is: ${check2 * check3}")

}

private fun part2 (lines: List<String>) {
}