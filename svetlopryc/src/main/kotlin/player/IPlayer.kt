package player

import field.Coordinates
import field.Field
import field.Limit

interface IPlayer {
    fun play(field: Field, limits: Limit): Coordinates
}