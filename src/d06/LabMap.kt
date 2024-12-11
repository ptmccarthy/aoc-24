package d06

class LabMap(private val grid: Array<Array<Char>>) {
    val guard = initGuard()

    fun moveGuard(): String {
        val current = Pair(guard.x, guard.y)
        val translation = guard.getTranslation(guard.direction)

        val next = Pair(
            current.first + translation.first,
            current.second + translation.second)

        setSpace(current.first, current.second, 'X')

        if (outOfBounds(next)) {
            return "exit"
        }

        var result: String
        when (getSpace(next.first, next.second)) {
            '.', 'X' -> result = guard.move()
            '#', 'O' -> result = guard.rotate()
            else -> { throw IllegalStateException("unknown character at $next")}
        }

        setSpace(guard.x, guard.y, guard.direction)
        return result
    }

    fun getSpace(x: Int, y: Int): Char {
        return grid[y][x]
    }

    fun getVisited(): Int {
        return grid.flatten().count { it == 'X' }
    }

    fun setSpace(x: Int, y: Int, char: Char) {
        grid[y][x] = char
    }

    private fun outOfBounds(next: Pair<Int,Int>): Boolean {
        try {
            getSpace(next.first, next.second)
        } catch (ex: IndexOutOfBoundsException) {
            return true
        }

        return false
    }

    private fun initGuard(): Guard {
        val dirChars = charArrayOf('^', '>', 'v', '<')

        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (dirChars.contains(grid[i][j])) {
                    return Guard(j, i, grid[i][j])
                }
            }
        }

        throw IllegalStateException("No guard found in input!")
    }

    override fun toString(): String {
        var str = ""
        grid.forEach { row -> str += (row.joinToString(" ") + "\n") }

        return str
    }
}
