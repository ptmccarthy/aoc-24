package d04

fun main() {
    val reader = Reader()
    val grid = reader.read("src/d04/input.txt")

    val target = "XMAS"

    println("Part 1: ${search(grid, target)}")
}

fun search(grid: Array<CharArray>, target: String): Int {
    var hits = 0;

    for (i in 0 until grid.size) {
        hits += searchRow(grid[i], target)
        hits += searchColumn(grid, i, target)

        if (i > grid.size - target.length) continue

        hits += searchDiagonals(grid, i, target)
    }

    return hits
}

fun searchRow(row: CharArray, target: String): Int {
    var hits = 0;

    for (i in 0 .. row.size - target.length) {
        val str = row.slice(i until i + target.length).joinToString("")

        if (str.equals(target) || str.reversed().equals(target)) {
            hits++
        }
    }

    return hits
}

fun searchColumn(grid: Array<CharArray>, columnIndex: Int, target: String): Int {
    var hits = 0;

    var str = ""
    for (i in 0 until grid.size) {
        str += grid[i][columnIndex]
    }

    for (i in 0 .. str.length - target.length) {
        val substr = str.slice(i until i + target.length)
        if (substr.equals(target) || substr.reversed().equals(target)) {
            hits++
        }
    }

    return hits
}

fun searchDiagonals(grid: Array<CharArray>, idx: Int, target: String): Int {
    var hits = 0;
    for (i in 0 .. grid.size - target.length) {
        val size = target.length
        val subGrid = extractSubgrid(grid, size, i, idx)

        val x1 = CharArray(size)
        for (j in 0 until size) {
            x1[j] = subGrid[j][j]
        }

        if (x1.joinToString("").equals(target) || x1.reversed().joinToString("").equals(target)) {
            hits++
        }

        val x2 = CharArray(size)
        for (k in 0 until size) {
            x2[k] = subGrid[k][size - 1 - k]
        }

        if (x2.joinToString("").equals(target) || x2.reversed().joinToString("").equals(target)) {
            hits++
        }
    }

    return hits
}

fun extractSubgrid(grid: Array<CharArray>, size: Int, startX: Int, startY: Int): Array<CharArray> {
    val subGrid = Array(size) { CharArray(size) }

    for (i in 0 until size) {
        for (j in 0 until size) {
            subGrid[i][j] = grid[startX + i][startY + j]
        }
    }

    return subGrid
}
