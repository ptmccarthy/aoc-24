package d02

import java.io.File

class Reader {

    fun readLines(path: String): List<List<Int>> {
        return File(path).readLines().map(
            { it.split(" ").map({ it.toInt() }) })
    }

}