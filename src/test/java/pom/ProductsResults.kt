package pom

import BasePOM
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions

class ProductsResults(
        driver: WebDriver
) : BasePOM(driver) {

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[3]/ul/li[1]/div/div[2]/span/span")
    private val tapResultPrice: WebElement? = null

    @FindBy(xpath = "/html/body/div[1]/div/div/main/div[3]/ul/li[1]/div/div[2]/span/span[1]")
    private val shelfResultPrice: WebElement? = null

    @FindBy(xpath = "//*[@id=\"dash_categories-2\"]/ul")
    private val categories: WebElement? = null

    override fun waitUntil(): ExpectedCondition<WebElement>? {
        return ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/main/div[3]/ul/li[1]/div/div[2]/h3/a"))
    }

    fun isPriceValid(expectedPrice: String): Boolean {
        print("Actual price: --${tapResultPrice?.text}--")
        return tapResultPrice?.text.equals(expectedPrice)
    }

    fun isToolsPriceValid(price: String): Boolean {
        print("Actual price: --${tapResultPrice?.text}--")
        return shelfResultPrice?.text.equals(price)
    }

    fun goToHabitationFromNavigation() {
        val elements = categories?.findElements(By.className("cat-parent"))
        print("SIZE -> ${elements?.size}")
        categories?.findElement(By.xpath("//*[@id=\"dash_categories-2\"]/ul/li[2]/a[1]"))?.click()
    }
}