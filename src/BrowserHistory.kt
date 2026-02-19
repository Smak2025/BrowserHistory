import java.util.Stack

class BrowserHistory(
    homepage: String,
) {

    private val history = Stack<String>()
    private val forward = Stack<String>()

    val currentUrl: String
        get() = history.peek()

    init{
        history.push(homepage)
    }

    fun visit(url: String){
        history.push(url)
    }

    fun back(steps: Int = 1){
        repeat(steps) {
            forward.push(history.pop())
        }
    }

    fun forward(steps: Int = 1){
        repeat(steps) {
            history.push(forward.pop())
        }
    }
}