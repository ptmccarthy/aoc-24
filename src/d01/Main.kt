package d01

import kotlin.math.abs

fun main() {

    val reader = Reader()

    val lines = reader.readSorted("src/d01/input.txt")
    val left = lines[0]
    val right = lines[1]

    // part one
    var sum = 0
    for (i in 0 until left.size) {
        sum += abs(left[i] - right[i])
    }

    println("Sum of distances: $sum")

    // part two
    val counts: Map<Int, Int> = right.fold(mutableMapOf()) { acc, i ->
        acc.put(i, acc.getOrDefault(i, 0) + 1)
        acc }

    val similarityScore = left.fold(0) { acc, i ->
        acc + i.times(counts.getOrDefault(i, 0))
    }

    println("Similarity score: $similarityScore")
}
