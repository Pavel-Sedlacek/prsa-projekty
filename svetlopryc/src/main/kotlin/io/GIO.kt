package io

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import field.Coordinates
import kotlin.math.abs

class GIO : IO {

    private val field =
        mutableStateMapOf<Coordinates, Boolean>().to2Dmap().map { it.toMutableStateList() }.toMutableStateList()

    private val application = application {
        Window(onCloseRequest = ::exitApplication) {
            Column {
                field.forEach { vl ->
                    Row {
                        vl.forEach { vl2 ->
                            Box(Modifier.background(Color(0, 25, 230)).fillMaxSize()) {

                            }
                        }
                    }
                }
            }
        }
    }

    override suspend fun readInput(limits: Pair<Pair<Int, Int>, Pair<Int, Int>>): Coordinates {
        return Coordinates(1, 1)
    }

    override fun preview(field: Map<Coordinates, Boolean>) {
        this.field.clear()
        for (i in field) {
            this.field[i.key.x][i.key.y] = i.value
        }
        println(this.field.toList())
    }
}

private fun Map<Coordinates, Boolean>.to2Dmap(): List<List<Boolean>> {
    var x = Pair(-3, 3)
    var y = Pair(-3, 3)
    try {
        x = this.minOf { it.key.x } - 3 to this.maxOf { it.key.x } + 3
        y = this.minOf { it.key.y } - 3 to this.maxOf { it.key.y } + 3
    } catch (e: Exception) {
        return listOf()
    }
    val l = List(abs(x.first - x.second)) { MutableList(abs(y.first - y.second)) { false } }
    for ((k, v) in this) {
        l[k.x][k.y] = v
    }
    return l
}
