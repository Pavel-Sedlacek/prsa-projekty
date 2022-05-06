package player

import field.Coordinates
import field.Limit

class AIPlayer : IPlayer {
    override fun play(field: Set<Coordinates>, limits: Limit): Coordinates {
        println("Currently ON : ${field.size}")

        val target = field.random()

        println("Playing at: $target")
        return target
    }
}