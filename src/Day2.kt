import java.io.File

fun main(args: Array<String>) {
    val lines = File("assets/day2.txt").readText().split('\n')
    part2(lines)
}

private fun part1 (lines: List<String>) {

    var check2 = 0
    var check3 = 0

    var map: MutableMap<Char,Int> = HashMap()

    for (str in lines) {
        for (chr in str) {
            map.put(chr, map.getOrDefault(chr, 0) + 1)
        }
        if (map.containsValue(2)) { check2++ }
        if (map.containsValue(3)) { check3++ }
        map.clear()
    }

    println("The result is: ${check2 * check3}")

}

private fun part2 (lines: List<String>) {

    println(lines.map { compareAll(it, lines) }.filter { it != null })
}

private fun compareAll (str: String, lines: List<String>) :String?{

    var balans: Int = 0
    var diffIndex: Int = 0

    for (line in lines) {
        if (line == str) continue
        for (ch in line.indices) {
            if (line[ch] !== str[ch]) {
                balans++
                diffIndex = ch
            }
            if (balans > 1) continue
        }
        if (balans == 1) return str.substring(0,diffIndex) + str.substring(diffIndex+1,str.length)
        balans = 0
    }
    return null

}