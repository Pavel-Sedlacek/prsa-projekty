import field.Field
import io.CIO
import io.IO

class Game {

    private val field: Field = Field(5)
    private val io: IO = CIO()

    suspend fun play() {
        while (!field.isHomogeneous()) {
            val inp = io.readInput(field.limits())
            field.play(inp)
            io.preview(field.fieldPreview)
        }
    }
}