package pom

import BasePOM
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions

class HomePage(
        driver: WebDriver
) : BasePOM(driver) {

    @FindBy(id = "show_login")
    private val loginButton: WebElement? = null

    @FindBy(id = "login")
    private val loginPopup: WebElement? = null

    override fun waitUntil(): ExpectedCondition<WebElement>? {
        return ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div"))
    }

    fun clickLoginButton() {
        loginButton?.click()
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("login")))
    }

    fun login(username: String, password: String) {
        loginPopup?.findElement(By.xpath("//*[@id=\"username\"]"))?.sendKeys(username)
        loginPopup?.findElement(By.xpath("//*[@id=\"password\"]"))?.sendKeys(password)
        loginPopup?.findElement(By.xpath("//*[@id=\"login\"]/input[3]"))?.click()
    }

    fun isLoginButtonVisible(): Boolean {
        return loginButton?.isDisplayed ?: false
    }

}