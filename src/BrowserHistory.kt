import java.util.Stack
import kotlin.math.min

class BrowserHistory(
    homepage: String,
) {
    private val history = Stack<String>()
    private val forward = Stack<String>()

    val historyLimit = 10

    val historySize: Int
        get() = history.size

    val currentUrl: String
        get() = history.peek()

    init{
        history.push(homepage)
    }

    fun visit(url: String){
        history.push(url)
        forward.clear()
        if (history.size > historyLimit){
            history.removeAt(0)
        }
    }

    fun back(steps: Int = 1){
        repeat(min(steps, history.size - 1)) {
            forward.push(history.pop())
        }
    }

    fun forward(steps: Int = 1){
        repeat(min(steps, forward.size)) {
            history.push(forward.pop())
        }
    }
}