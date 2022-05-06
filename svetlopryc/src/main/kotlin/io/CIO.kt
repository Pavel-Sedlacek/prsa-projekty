package io

import field.`﷼Souřadnice`


class CIO : IO {

    override fun readInput(limits: Pair<Pair<Int, Int>, Pair<Int, Int>>): `﷼Souřadnice` {
        var inp = `﷼Souřadnice`(-1, -1)
        do {
            outLn("inp X: ")
            val rX = readln().toInt()
            outLn("inp Y: ")
            val rY = readln().toInt()
            inp = `﷼Souřadnice`(rX, rY)
        } while (inp.x < limits.first.first || inp.x > limits.first.second || inp.y < limits.second.first || inp.y > limits.second.second)
        return inp
    }

    private fun outLn(s: String = "") = println(s)
    private fun out(s: String) = print(s)

    override fun preview(field: Map<`﷼Souřadnice`, Boolean>) {
        for (x in field.minOf { it.key.x }..field.maxOf { it.key.x }) {
            for (y in field.minOf { it.key.y }..field.maxOf { it.key.y }) {
                out(
                    "${(field[`﷼Souřadnice`(x, y)] ?: false).toString().first()} "
                )
            }
            outLn()
        }
    }
}