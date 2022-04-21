package field

import IO
import player.Symbol

class Field(private val winCount: Int = 3) {
    private val c = mutableMapOf<Coordinate, Symbol>()

    val fieldView: Map<Coordinate, Symbol>
        get() = c.toMap()

    fun play(coordinate: Coordinate, symbol: Symbol): Boolean {
        c[coordinate] = symbol
        return hasWon(coordinate, symbol)
    }

    fun showField(field: Field) {
        val c = field.fieldView
        val minX = c.minOf { it.key.x } - 3
        val minY = c.minOf { it.key.y } - 3
        val maxX = c.maxOf { it.key.x } + 3
        val maxY = c.maxOf { it.key.y } + 3


        for (x in minX..maxX) {
            for (y in minY..maxY) {
                IO.out(
                    (c[Coordinate(x, y)]?.symbol?.plus(" ")) ?: "? "
                )
            }
            IO.outLn()
        }
    }

    private fun hasWon(coord: Coordinate, symbol: Symbol): Boolean {
        val inLineae = mutableListOf(0, 0, 0, 0)
        for (i in -winCount..winCount) {
            if (c[Coordinate(coord.x + i, coord.y)] == symbol) inLineae[0]++ else inLineae[0] = 0
            if (c[Coordinate(coord.x, coord.y + i)] == symbol) inLineae[1]++ else inLineae[1] = 0
            if (c[Coordinate(coord.x + i, coord.y + i)] == symbol) inLineae[2]++ else inLineae[2] = 0
            if (c[Coordinate(coord.x - i, coord.y + i)] == symbol) inLineae[3]++ else inLineae[3] = 0
            if (inLineae.any { it >= winCount }) return true
        }
        return false
    }

    operator fun contains(coord: Coordinate): Boolean = c.contains(coord)
}