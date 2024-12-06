package d05

import java.io.File

class Reader {

    fun readRules(path: String): Map<Int, List<Int>> {
        val lines = File(path).readLines()
        val ruleRegex = Regex("\\d+\\|\\d+")

        val rules = mutableMapOf<Int, MutableList<Int>>()

        for (line in lines) {
            ruleRegex.findAll(line).forEach {
                val (first, second) = it.value.split("|").map { it.toInt() }
                rules.putIfAbsent(first, mutableListOf())
                rules[first]?.add(second)
            }
        }

        return rules.toMap()
    }

    fun readUpdates(path: String): List<List<Int>> {
        val lines = File(path).readLines()
        val updateRegex = Regex("\\d+,\\d+(,\\d+)*")

        val updates = mutableListOf<List<Int>>()

        for (line in lines) {
            updateRegex.findAll(line).forEach {
                val update = it.value.split(",").map { it.toInt() }
                updates.add(update)
            }
        }

        return updates.toList()
    }
}