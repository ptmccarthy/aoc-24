package d02

fun main() {

    val reader = Reader()
    val lines = reader.readLines("src/d02/input.txt")

    val scorer = Scorer()
    val safe1: Int = lines.fold(0) { acc, i ->
        acc + if (scorer.isSafe(i, false)) 1 else 0
    }

    println("Safe part 1: $safe1")

    val safe2: Int = lines.fold(0) { acc, i ->
        acc + if (scorer.isSafe(i, true)) 1 else 0
    }

    println("Safe part 2: $safe2")
}