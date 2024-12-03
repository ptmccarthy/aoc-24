package d01

import java.io.File

class Reader {

    fun readLines(path: String): List<List<Int>> {
        return File(path).readLines()
            .map { it.split("   ").map { it.toInt() } }
    }

    fun readSorted(path: String): List<List<Int>> {
        val left: MutableList<Int> = mutableListOf()
        val right: MutableList<Int> = mutableListOf()

        val lines = readLines(path)
        for (i in 0 until lines.size) {
            left.add(lines[i][0])
            right.add(lines[i][1])
        }

        return listOf(left.sorted(), right.sorted())
    }
}