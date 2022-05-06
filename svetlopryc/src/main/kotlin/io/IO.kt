package io

import field.Coordinates
import field.Limit

interface IO {
    fun read(limits: Limit): Coordinates
    fun view(field: Set<Coordinates>, limits: Limit)

}