package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver = null;
    LoginPage login;

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

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        login = new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {
        login.submit();
        Thread.sleep(2000);
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        login.validateLogin();
    }
}
