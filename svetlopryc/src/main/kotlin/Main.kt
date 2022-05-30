import io.CIO
import player.AIPlayer
import player.HumanPlayer

fun main(args: Array<String>) {
    val p = HumanPlayer(CIO)
    val a = AIPlayer(24)
    val x = Game(a, 3)
    x.play()
}