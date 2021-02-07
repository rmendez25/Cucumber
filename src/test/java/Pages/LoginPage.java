package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(name = "userName")
    WebElement input_username;

    @FindBy(name = "password")
    WebElement input_password;

    @FindBy(name = "submit")
    WebElement btn_submit;

    @FindBy(xpath = "//h3[contains(text(), 'Login Successfully')]")
    WebElement message;

    public void enterUsername(String username){
        input_username.sendKeys(username);
    }

    public void enterPassword(String pass){
        input_password.sendKeys(pass);
    }

    public void submit(){
        btn_submit.click();
    }
    
    public void validateLogin(){
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(message.isDisplayed());
    }
}
