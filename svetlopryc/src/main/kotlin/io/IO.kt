package io

import field.Coordinates

interface IO {
    suspend fun readInput(limits: Pair<Pair<Int, Int>, Pair<Int, Int>>): Coordinates
    fun preview(field: Map<Coordinates, Boolean>)
}