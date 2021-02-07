package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void browser_is_open() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user is on google search page")
    public void user_is_on_google_search_page() {
        driver.get("https://google.com");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() {
        driver.findElement(By.name("q")).sendKeys("Cucumber");
    }

    @When("hits enter")
    public void hits_enter() {
        driver.findElement(By.name("btnK")).submit();
    }

    @Then("user is navigate to search results")
    public void user_is_navigate_to_search_results() {
        WebElement cucumberLogo = driver.findElement(By.xpath("//img[@id='wp_thbn_21']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cucumberLogo));
        Assert.assertTrue(cucumberLogo.isDisplayed());
        driver.close();
        driver.quit();
    }
}
