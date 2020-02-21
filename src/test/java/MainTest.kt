import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pom.HomePage
import pom.MyAccount
import pom.ProductsResults
import java.net.URI


class MainTest {
    private val landingUrl = "https://www.vinkoprom.com/"
    private val testEmail = "naloc46523@xhyemail.com"
    private val testPassword = "12345678"

    //TEST 2
    private val expectedHabitationPrice = "329,00 kn"
    //TEST 3
    private val expectedToolPrice = "149,00 kn"

    private lateinit var driver: WebDriver

    @BeforeMethod
    private fun setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe")
        driver = ChromeDriver()
        driver.manage().window().maximize()
        driver.navigate().to(URI(landingUrl).toString())
    }

    private fun goToLogin(): MyAccount {
        val homePage = HomePage(driver)
        homePage.clickLoginButton()
        homePage.login(testEmail, testPassword)
        return MyAccount(driver)
    }

    @Test
    private fun testLogin() {
        val myAccount = goToLogin()
        Assert.assertEquals(true, myAccount.pageVisible())
    }

    @Test
    fun testHabitationResults() {
        val myAccount = goToLogin()
        myAccount.goToHabitations()
        val habitationsResults = ProductsResults(driver)
        Assert.assertEquals(true, habitationsResults.isPriceValid(expectedHabitationPrice))
    }

    @Test
    fun testToolsResults() {
        val myAccount = goToLogin()
        myAccount.goToMyTools()
        val toolsResults = ProductsResults(driver)
        Assert.assertEquals(true, toolsResults.isToolsPriceValid(expectedToolPrice))
    }

    @Test
    fun testHabitationResultsByDifferentNavigation() {
        val myAccount = goToLogin()
        myAccount.goToMyTools()
        val toolsResults = ProductsResults(driver)
        toolsResults.goToHabitationFromNavigation()
        val habitationsResults = ProductsResults(driver)
        Assert.assertEquals(true, habitationsResults.isPriceValid(expectedHabitationPrice))
    }

    @Test
    fun testLogout() {
        val myAccount = goToLogin()
        myAccount.logout()
        val home = HomePage(driver)
        Assert.assertEquals(true, home.isLoginButtonVisible())
    }

    @AfterMethod
    fun teardownTest() {
        driver.quit()
    }
}