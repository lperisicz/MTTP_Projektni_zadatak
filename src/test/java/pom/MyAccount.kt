package pom

import BasePOM
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions

class MyAccount(
        driver: WebDriver
) : BasePOM(driver) {

    @FindBy(xpath = "//*[@id=\"dash_login-2\"]/a[2]")
    private val logoutButton: WebElement? = null

    @FindBy(xpath = "//*[@id=\"mega-menu-item-202\"]/a")
    private val habitation: WebElement? = null

    @FindBy(xpath = "//*[@id=\"mega-menu-item-194\"]/a")
    private val tools: WebElement? = null

    override fun waitUntil(): ExpectedCondition<WebElement>? {
        return ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/main/div/div/nav"))
    }

    fun goToHabitations() {
        habitation?.click()
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mega-menu-item-202\"]/ul")))
        habitation?.click()
    }

    fun goToMyTools() {
        tools?.click()
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mega-menu-item-194\"]/ul")))
        driver.findElement(By.xpath("//*[@id=\"mega-menu-item-175\"]")).click()
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mega-menu-item-176\"]")))
        driver.findElement(By.xpath("//*[@id=\"mega-menu-item-176\"]")).click()
    }

    fun logout() {
        logoutButton?.click()
    }

    fun pageVisible() = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/main/div/div/nav/ul/li[5]/a")).isDisplayed
}