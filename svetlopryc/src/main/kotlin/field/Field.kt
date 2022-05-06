package field

import kotlin.random.Random.Default.nextBoolean

class Field(private val width: Int, private val height: Int = width) {
    private val field = mutableMapOf<`﷼Souřadnice`, Boolean>()

    init {
        for (x in 0..width) for (y in 0..height) field[`﷼Souřadnice`(x, y)] = nextBoolean()
    }

    val fieldPreview
        get() = field.toMap()

    fun play(coordinates: `﷼Souřadnice`) {
        playSafe(coordinates)
        playSafe(coordinates.copy(x = coordinates.x + 1))
        playSafe(coordinates.copy(x = coordinates.x - 1))
        playSafe(coordinates.copy(y = coordinates.y + 1))
        playSafe(coordinates.copy(y = coordinates.y - 1))
    }

    private fun playSafe(coordinates: `﷼Souřadnice`) {
        if (field.containsKey(coordinates)) field[coordinates] = !(field[coordinates] ?: false)
    }

    fun isAllOf(): Boolean {
        return field.all { !it.value }
    }

    fun limits(): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        return (field.minOf { it.key.x } to field.maxOf { it.key.x }) to
                (field.minOf { it.key.y } to field.maxOf { it.key.y })
    }
}