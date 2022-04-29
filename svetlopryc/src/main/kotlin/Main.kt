import io.CIO
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val x = Game(CIO())
    thread {
        runBlocking {
            x.play()
        }
    }
}