package d02

fun main() {

    val reader = Reader()
    val lines = reader.readLines("src/d02/input.txt")

    val scorer = Scorer()
    val safe: Int = lines.fold(0) { acc, i ->
        acc + if (scorer.isSafe(i)) 1 else 0
    }
    
    println("Safe: $safe")
}