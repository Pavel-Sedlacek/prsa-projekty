fun main() {
    val x = ContainerImpl

    x.getOrCreateInstance(F::class)
    println("instance of F exists: " + x.hasInstance(F::class))

    x.getOrCreateInstance(D::class)
    println("instance of D exists: " + x.hasInstance(D::class))

    println(x.getOrCreateInstance(D::class))
}

class F
class D(f: F)