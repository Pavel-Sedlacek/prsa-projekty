package io

import field.Coordinates
import field.Limit


object CIO : IO {

    override fun read(limits: Limit): Coordinates {
        var inp: Coordinates
        do {
            println("input X coordinate")
            val rX = readln().toInt()
            println("input Y coordinate ")
            val rY = readln().toInt()
            inp = Coordinates(rX, rY)
        } while (inp.x !in limits.first || inp.y !in limits.second)
        return inp
    }

    override fun view(field: Set<Coordinates>, limits: Limit) {
        for (x in limits.first) {
            for (y in limits.second) {
                print(if (field.contains(Coordinates(x, y))) "⬜ " else "⬛ ")
            }
            println()
        }
    }
}