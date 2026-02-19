fun main() {
    val browser = BrowserHistory("www.ya.ru")
    println(browser.currentUrl)
    browser.visit("www.google.com")
    println(browser.currentUrl)
    browser.visit("www.qwen.ai")
    println(browser.currentUrl)
    browser.visit("www.kpfu.ru")
    println(browser.currentUrl)
    browser.visit("www.megafon.ru")
    println(browser.currentUrl)
    println("Сейчас пойдем назад. На сколько шагов?")
    val bSteps = readln().toIntOrNull() ?: 1
    browser.back(bSteps)
    println(browser.currentUrl)
    println("Сейчас пойдем вперед. На сколько шагов?")
    val fSteps = readln().toIntOrNull() ?: 1
    browser.forward(fSteps)
    println(browser.currentUrl)
}