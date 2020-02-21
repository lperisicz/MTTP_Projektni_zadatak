import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

@Suppress("LeakingThis")
abstract class BasePOM(
        protected val driver: WebDriver
) {

    private var wait: WebDriverWait = WebDriverWait(driver, 30)

    init {
        PageFactory.initElements(driver, this)
        waitUntil()?.let { waitFor(it) }
    }

    protected fun waitFor(condition: ExpectedCondition<WebElement>) {
        wait.until<WebElement>(condition)
    }

    //Added this so every page that is loaded can override wait for fully loaded page
    abstract fun waitUntil(): ExpectedCondition<WebElement>?

}