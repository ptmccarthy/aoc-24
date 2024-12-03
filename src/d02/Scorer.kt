package d02

import kotlin.math.abs

class Scorer {

    fun isSafe(reports: List<Int>, enableDampener: Boolean): Boolean {
        var increasing = true;
        var decreasing = true;
        var gradual = true;

        for (i in 0 until reports.size - 1) {
            val diff = reports[i] - reports[i + 1]

            increasing = increasing && diff <= -1
            decreasing = decreasing && diff >= 1
            gradual = gradual && IntRange(1,3).contains(abs(diff))
        }

        val safe = (increasing || decreasing) && gradual

        if (!safe && enableDampener) {
            for (i in 0 until reports.size) {
                if (isSafe(dampenReport(reports, i), false)) {
                    return true
                }
            }
        }

        return safe
    }

    fun dampenReport(report: List<Int>, index: Int): List<Int> {
        val dampened = report.filterIndexed({ i, _ -> i != index })
        return dampened
    }
}

