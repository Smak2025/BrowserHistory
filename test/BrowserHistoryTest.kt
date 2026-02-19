import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BrowserHistoryTest {

    lateinit var browser: BrowserHistory

    @BeforeEach
    fun setUp() {
        browser = BrowserHistory("www.ya.ru")
        browser.visit("www.google.com")
        browser.visit("www.qwen.ai")
        browser.visit("www.kpfu.ru")
        browser.visit("www.megafon.ru")
    }

    @Test
    fun getCurrentUrl() {
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.megafon.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun visit() {

    }

    @Test
    fun backOneStep() {

    }

    @Test
    fun backTwoSteps() {

    }


    @Test
    fun forward() {
    }

}