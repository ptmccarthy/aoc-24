package d06

class Guard(var x: Int, var y: Int, var direction: Char) {
    var loop = mutableMapOf<Pair<Int,Int>, Char>()

    fun move(): String {
        val translation = getTranslation(direction)

        x = x + translation.first
        y = y + translation.second

        val p = Pair(x,y)

        if (loop.get(p) == direction) {
            return "loop"
        }

        loop.put(Pair(x, y), direction)
        return "next"
    }

    fun rotate(): String {
        when (direction) {
            '^' -> direction = '>'
            '>' -> direction = 'v'
            'v' -> direction = '<'
            '<' -> direction = '^'
        }
        return "next"
    }

    fun getTranslation(arrow: Char): Pair<Int, Int> {
        return when (arrow) {
            '^' -> Pair(0, -1) // Move up
            '>' -> Pair(1, 0)  // Move right
            'v' -> Pair(0, 1)  // Move down
            '<' -> Pair(-1, 0) // Move left
            else -> throw IllegalArgumentException("Invalid arrow character: $arrow")
        }
    }
}
