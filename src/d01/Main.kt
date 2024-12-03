package d01

import java.io.File
import kotlin.math.abs

fun main() {

    val reader = Reader()

    val lines = reader.readSorted("src/d01/input.txt")

    var sum = 0
    for (i in 0 until lines[0].size) {
        sum += abs(lines[0][i] - lines[1][i])
    }

    println("Sum of distances: $sum")
}
