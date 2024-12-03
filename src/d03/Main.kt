package d03

fun main() {
    val reader = Reader()
    val lines = reader.readLines("src/d03/input.txt")

    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

    var sum = 0;

    lines.forEach { line ->
        val matches = regex.findAll(line)

        var result = 0
        for (match in matches) {
            val (a, b) = match.destructured
            result += a.toInt() * b.toInt()
        }

        sum += result
    }

    println(sum)
}