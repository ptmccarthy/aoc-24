package d06

import java.io.File

class Reader {
    fun readLines(path: String): Array<Array<Char>> {
        return File(path).readLines().map { it.toCharArray().toTypedArray() }.toTypedArray()
    }
}

