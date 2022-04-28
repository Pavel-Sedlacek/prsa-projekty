package field

import kotlin.random.Random.Default.nextBoolean

class Field(private val width: Int, private val height: Int = width) {
    private val field = mutableMapOf<Coordinates, Boolean>()

    init {
        for (x in 0..width) for (y in 0..height) field[Coordinates(x, y)] = nextBoolean()
    }

    val fieldPreview
        get() = field.toMap()

    fun play(coordinates: Coordinates) {
        field[coordinates] = !(field[coordinates] ?: false)
    }

    fun isHomogeneous(): Boolean {
        return false
    }

    fun limits(): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        return (field.minOf { it.key.x } to field.maxOf { it.key.x }) to
                (field.minOf { it.key.y } to field.maxOf { it.key.y })
    }
}