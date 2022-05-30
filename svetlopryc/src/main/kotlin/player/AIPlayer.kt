package player

import field.Coordinates
import field.Field
import field.Limit

class AIPlayer(private val depth: Int) : IPlayer {

    override fun play(field: Field, limits: Limit): Coordinates {
        println("Currently ON : ${field.rank}")

        val li: MutableMap<Int, MutableMap<List<Coordinates>, Field>> = mutableMapOf()

        li[0] = mutableMapOf()
        for (x in limits.first) {
            for (y in limits.second) {
                Coordinates(x, y).also { c ->
                    val z = field.fieldPreview.also { f -> f.play(c) }
                    if (z.rank == 0) {
                        println("Playing at: $c")
                        return c
                    }
                    li[0]?.put(listOf(c), z)
                }
            }
        }

        for (j in 1..depth) {
            li[j] = mutableMapOf()
            for (i in li[j - 1]!!) {
                for (x in limits.first) {
                    for (y in limits.second) {
                        Coordinates(x, y).also { c ->
                            val z = i.value.fieldPreview.also { f -> f.play(c) }
                            if (z.rank == 0) {
                                println("Playing at: ${i.key.first()}")
                                return i.key.first()
                            }
                            li[j]?.put(i.key + c, z)
                        }
                    }
                }
            }
        }

        val target = li[depth]?.maxByOrNull { it.value.rank }?.key?.random() ?: field.pure.random()


        println("Playing at: $target")
        return target
    }
}