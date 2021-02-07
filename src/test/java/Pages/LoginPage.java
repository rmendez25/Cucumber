package Pages;

import Utils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "userName")
    WebElement input_username;

    @FindBy(name = "password")
    WebElement input_password;

    @FindBy(name = "submit")
    WebElement btn_submit;

    @FindBy(xpath = "//h3[contains(text(), 'Login Successfully')]")
    WebElement message;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

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
        waitForElementToAppear(message);
        Assert.assertTrue(message.isDisplayed());
    }
}
