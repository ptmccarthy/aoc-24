package d02

import kotlin.math.abs

class Scorer {

    fun isSafe(reports: List<Int>): Boolean {
        val sorted = reports.sorted()

        val increasing = reports == sorted
        val decreasing = reports == sorted.reversed()

        var isGradual = true;
        for (i in 0 until reports.size - 1) {
            val absDiff = abs(reports[i] - reports[i+1])

            isGradual = isGradual && IntRange(1,3).contains(absDiff)
        }

        return (increasing || decreasing) && isGradual
    }

}