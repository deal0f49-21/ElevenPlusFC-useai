package com.londonjobs.elevenplusfc.util

data class SM2Result(
    val newInterval: Int,
    val newEase: Double,
    val nextDate: Long
)

/**
 * Simple implementation of the SuperMemo 2 algorithm.
 * rating: 0–5 (0=forgot completely, 5=perfect recall)
 */
object SM2 {
    fun review(prevInterval: Int, prevEase: Double, rating: Int): SM2Result {
        var ef = prevEase + (0.1 - (5 - rating) * (0.08 + (5 - rating) * 0.02))
        if (ef < 1.3) ef = 1.3

        val newInterval = when {
            rating < 3 -> 1
            prevInterval == 1 -> 2
            else -> (prevInterval * ef).toInt().coerceAtLeast(1)
        }

        val nextDate = System.currentTimeMillis() + newInterval * 24L * 60 * 60 * 1000
        return SM2Result(newInterval, ef, nextDate)
    }
}
