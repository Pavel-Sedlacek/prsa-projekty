import field.Field
import player.IPlayer

class Game(private val player: IPlayer, size: Int) {

    private val field: Field = Field(size)

    fun play() {
        var turn = 0
        while (!field.isAllOff) {
            field.play(player.play(field.fieldPreview, field.limits))
            println("Current turn : ${turn++}")
        }
    }
}