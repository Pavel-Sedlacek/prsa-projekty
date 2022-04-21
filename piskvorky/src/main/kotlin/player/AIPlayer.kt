package player

import field.Coordinate
import field.Field
import kotlin.random.Random.Default.nextInt

class AIPlayer(override val name: String, override val symbol: Symbol): IPlayer {

    private var hasWon = false

    override fun nextMove(field: Field): Coordinate {
        while (true) {
            val oc = field.fieldView.keys.random()
            val c = oc.copy(x = oc.x + nextInt(-1, 1), y = oc.y + nextInt(-1, 1))
            if (c !in field) return c
        }
    }

    override fun won() {
        hasWon = true
    }

    override fun hasWon(): Boolean = hasWon
}