package player

import field.Coordinates
import field.Limit

interface IPlayer {
    fun play(field: Set<Coordinates>, limits: Limit): Coordinates
}