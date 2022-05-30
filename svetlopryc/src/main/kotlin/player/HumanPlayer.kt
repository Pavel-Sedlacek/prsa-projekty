package player

import field.Coordinates
import field.Field
import field.Limit
import io.IO


class HumanPlayer(private val io: IO) : IPlayer {
    override fun play(field: Field, limits: Limit): Coordinates {
        io.view(field.pure, limits)
        return io.read(limits)
    }
}