import field.Field
import io.IO

class Game(private val io: IO) {

    private val field: Field = Field(5)

    suspend fun play() {
        while (!field.isAllOf()) {
            val inp = io.readInput(field.limits())
            field.play(inp)
            io.preview(field.fieldPreview)
        }
    }
}