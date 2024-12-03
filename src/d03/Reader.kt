package d03

import java.io.File

class Reader {
    fun readLines(path: String): List<String> {
        return File(path).readLines()
    }
}