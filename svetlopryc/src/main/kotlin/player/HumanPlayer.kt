package player

import field.Coordinates
import field.Limit
import io.IO


class HumanPlayer(private val io: IO) : IPlayer {
    override fun play(field: Set<Coordinates>, limits: Limit): Coordinates {
        io.view(field, limits)
        return io.read(limits)
    }
}