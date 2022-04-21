import field.Field
import player.AIPlayer
import player.HumanPlayer
import player.Symbol

fun main() {
    val players = listOf(
        HumanPlayer("hrac 1", Symbol.CIRCLE),
        AIPlayer("hrac 2", Symbol.CROSS)
    )
    val field = Field()

    var index = 0

    while (players.none { it.hasWon() }) {
        val cp = players[index++ % players.size]
        IO.outLn("Player ${cp.name} (${cp.symbol.symbol})")
        if (field.play(cp.nextMove(field), cp.symbol)) cp.won()
        field.showField(field)
    }

    IO.outLn("Congrats")
}