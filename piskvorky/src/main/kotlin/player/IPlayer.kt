package player

import field.Coordinate
import field.Field

interface IPlayer {
    val name: String
    val symbol: Symbol

    fun nextMove(field: Field): Coordinate
    fun won()
    fun hasWon(): Boolean
}