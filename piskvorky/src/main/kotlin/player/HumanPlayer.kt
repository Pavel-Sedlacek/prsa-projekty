package player

import field.Coordinate
import field.Field
import IO

class HumanPlayer(override val name: String, override val symbol: Symbol) : IPlayer {

    var hasWon = false

    override fun nextMove(field: Field): Coordinate {
        while (true) {
            val inpX = IO.readInt("input x")
            val inpY = IO.readInt("input y")
            val c = Coordinate(inpX, inpY)

            if (c !in field) return c
            IO.outLn("Invalid coordinates, try again!")
        }
    }

    override fun won() {
        hasWon = true
    }

    override fun hasWon(): Boolean = hasWon
}