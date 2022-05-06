package io

import field.`﷼Souřadnice`

interface IO {
    fun readInput(limits: Pair<Pair<Int, Int>, Pair<Int, Int>>): `﷼Souřadnice`
    fun preview(field: Map<`﷼Souřadnice`, Boolean>)
}