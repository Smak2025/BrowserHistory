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
    fun visitNewSite() {
        browser.visit("www.gosuslugi.ru")
        val actualUrl = browser.currentUrl
        val expectedUrl = "www.gosuslugi.ru"
        assertEquals(expectedUrl, actualUrl)
    }

    @Test
    fun visit6Urls() {
        browser.visit("www.gosuslugi.ru")
        browser.visit("www.nalog.ru")
        browser.visit("www.stepik.org")
        browser.visit("www.intuit.ru")
        browser.visit("www.leetcode.ru")
        browser.visit("www.vk.ru")
        val actualUrl = browser.currentUrl
        val expectedUrl = "www.vk.ru"
        assertEquals(expectedUrl, actualUrl)
        val actualStackSize = browser.historySize
        val expectedStackSize = browser.historyLimit
        assertEquals(expectedStackSize, actualStackSize)
    }

    @Test
    fun backOneStep() {
        browser.back()
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.kpfu.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun backTwoSteps() {
        browser.back(2)
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.qwen.ai"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun backSevenSteps() {
        browser.back(7)
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.ya.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun backM1Steps() {
        browser.back(-1)
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.megafon.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }


    @Test
    fun forwardWithoutBack() {
        browser.forward()
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.megafon.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun forwardAfterOneBack() {
        browser.back()
        browser.forward()
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.megafon.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun forwardM1AfterOneBack() {
        browser.back(2)
        browser.forward(-1)
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.qwen.ai"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun back3VisitForward1(){
        browser.back(3)
        browser.visit("www.gosuslugi.ru")
        browser.forward()
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.gosuslugi.ru"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

    @Test
    fun back3VisitForward1Back1(){
        browser.back(3)
        browser.visit("www.gosuslugi.ru")
        browser.forward()
        browser.back()
        val actualCurrentUrl = browser.currentUrl
        val expectedCurrentUrl = "www.google.com"
        assertEquals(expectedCurrentUrl, actualCurrentUrl)
    }

}