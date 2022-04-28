import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val x = Game()
    thread {
        runBlocking {
            x.play()
        }
    }
}