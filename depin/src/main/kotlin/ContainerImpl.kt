import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

object ContainerImpl : IContainer {

    private val container = mutableMapOf<KClass<*>, Any>()

    override fun <T : Any> getOrCreateInstance(kClass: KClass<T>): T {
        if (!hasInstance(kClass)) container[kClass] =
            kClass::primaryConstructor.get()!!.callBy(kClass.primaryConstructor!!.parameters.associateWith {
                getOrCreateInstance(it.type.jvmErasure)
            }
            )
        return container[kClass] as T
    }

    override fun hasInstance(kClass: KClass<*>): Boolean = container.contains(kClass)
}