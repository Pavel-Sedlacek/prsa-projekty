package field

import kotlin.random.Random.Default.nextBoolean

typealias Limit = Pair<IntRange, IntRange>

class Field(private val width: Int, private val height: Int = width) {

    private val field = mutableSetOf<Coordinates>()

    val limits: Limit
        get() = 0..width to 0..height

    val fieldPreview
        get() = field.toSet()

    val isAllOff
        get() = field.isEmpty()

    init {
        for (x in 0..width) for (y in 0..height)
            if (nextBoolean()) field.add(Coordinates(x, y))
    }

    fun play(coordinates: Coordinates) {
        playSafe(coordinates)
        playSafe(coordinates.copy(x = coordinates.x + 1))
        playSafe(coordinates.copy(x = coordinates.x - 1))
        playSafe(coordinates.copy(y = coordinates.y + 1))
        playSafe(coordinates.copy(y = coordinates.y - 1))
    }

    private fun playSafe(coordinates: Coordinates) {
        if (coordinates.x in 0..width && coordinates.y in 0..height)
            if (field.contains(coordinates)) field.remove(coordinates)
            else field.add(coordinates)
    }
}