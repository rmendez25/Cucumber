package StepDefinitions;

import Pages.GoogleSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {

    WebDriver driver;
    GoogleSearchPage google;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void cleanup(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    @Given("browser is open")
    public void browser_is_open() {
        driver.manage().window().maximize();
        google = new GoogleSearchPage(driver);
    }

    @Given("user is on google search page")
    public void user_is_on_google_search_page() {
        driver.get("https://google.com");
        google.isLogoVisible();
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() {
        google.setSearchBox("Cucumber");
    }

    @When("hits enter")
    public void hits_enter() {
        google.submitBtn();
    }

    @Then("user is navigate to search results")
    public void user_is_navigate_to_search_results() {
        google.isNavigatedToResultPage();
    }
}
