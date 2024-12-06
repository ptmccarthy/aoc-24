package d05

fun main() {
    val reader = Reader()
    val path = "src/d05/input.txt"

    val rules = reader.readRules(path)
    val updates = reader.readUpdates(path)

    var sum = 0
    for (update in updates) {
        sum += processUpdate(update, rules)
    }

    println("Part One: $sum")
}

fun processUpdate(update: List<Int>, rules: Map<Int, List<Int>>): Int {
    var valid = true
    for (i in update.indices) {
        val page = update[i]

        for (rule in rules.getOrDefault(page, listOf())) {
            val ruleIdx = update.indexOf(rule)

            if (ruleIdx > -1) {
                valid = valid && i < ruleIdx
            }
        }
    }

    if (valid) {
        val midpoint: Int = update.size / 2
        return update[midpoint]
    }
    return 0
}
