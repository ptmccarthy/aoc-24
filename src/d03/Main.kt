package d03

fun main() {
    val reader = Reader()
    val lines = reader.readLines("src/d03/input.txt")

    println("Part 1: ${partOne(lines)}")
    println("Part 2: ${partTwo(lines)}")
}

fun partOne(lines: List<String>): Int {
    return lines.fold(0, { acc, line -> acc + sumProducts(line) })
}

fun partTwo(lines: List<String>): Int {
    val line = lines.joinToString()
    val delimDo = "do()"
    val delimDont = "don't()"

    var sum = 0

    val beginIdx = line.indexOf(delimDont)
    val begin = line.substring(0, beginIdx)
    var remaining = line.substring(beginIdx + delimDont.length)

    sum += sumProducts(begin)

    while (remaining.contains(delimDo)) {
        // go to next do()
        val doIdx = remaining.indexOf(delimDo)
        remaining = remaining.substring(doIdx)

        // find next don't()
        val dontIdx = remaining.indexOf(delimDont)

        // if none, its the end of the line
        if (dontIdx == -1) {
            sum += sumProducts(remaining)
            remaining = ""
        // extract the string until the next don't()
        } else {
            val doRange = remaining.substring(0, dontIdx)
            sum += sumProducts(doRange)
            remaining = remaining.substring(dontIdx + delimDont.length)
        }
    }

    return sum
}

fun sumProducts(line: String): Int {
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    val matches = regex.findAll(line)

    var result = 0
    for (match in matches) {
        val (a, b) = match.destructured
        result += a.toInt() * b.toInt()
    }

    return result
}