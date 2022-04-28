package io

import field.Coordinates

class CIO : IO {

    override suspend fun readInput(limits: Pair<Pair<Int, Int>, Pair<Int, Int>>): Coordinates {
        var inp = Coordinates(-1, -1)
        do {
            outLn("inp X: ")
            val rX = readln().toInt()
            outLn("inp Y: ")
            val rY = readln().toInt()
            inp = Coordinates(rX, rY)
        } while (inp.x < limits.first.first || inp.x > limits.first.second || inp.y < limits.second.first || inp.y > limits.second.second)
        return inp
    }

    private fun outLn(s: String = "") = println(s)
    private fun out(s: String) = print(s)

    override fun preview(field: Map<Coordinates, Boolean>) {
        for (x in field.minOf { it.key.x }..field.maxOf { it.key.x }) {
            for (y in field.minOf { it.key.y }..field.maxOf { it.key.y }) {
                out(
                    "${(field[Coordinates(x, y)] ?: false).toString().first()} "
                )
            }
            outLn()
        }
    }
}