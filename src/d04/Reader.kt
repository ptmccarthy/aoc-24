package d04

import java.io.File

class Reader {
    fun read(path: String): Array<CharArray> {
        val lines = File(path).readLines()

        return lines.map { it.toCharArray() }.toTypedArray()
    }
}