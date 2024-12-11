package d06

fun main() {
    val grid = Reader().readLines("src/d06/input.txt")

    val labMap = LabMap(deepCopy(grid))

    while (labMap.moveGuard() == "next") {}
    println("Part One: ${labMap.getVisited()}")

    var loops = 0
    for (i in 0 until grid.size) {
        for (j in 0 until grid[i].size) {
            val lab = LabMap(deepCopy(grid))

            lab.setSpace(j, i, 'O')

            var result: String
            do {
                result = lab.moveGuard()
            } while (result == "next")

            if (result == "loop") {
                loops++
            }
        }
    }

    println("Part Two: $loops")
}

fun deepCopy(grid: Array<Array<Char>>): Array<Array<Char>> {
    return grid.map { it.clone() }.toTypedArray()
}
