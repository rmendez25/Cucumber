package Pages;

import Utils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExamplePage extends BasePage {

    @FindBy(xpath = "//img[@alt='Google']")
    WebElement logo;

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnK")
    WebElement searchButton;

    @FindBy(xpath = "//img[@id='wp_thbn_21']")
    WebElement cucumberLogo;

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    public void isLogoVisible(){
        Assert.assertTrue(logo.isDisplayed());
    }

    public void setSearchBox(String text){
        searchBox.sendKeys(text);
    }

    public void submitBtn(){
        searchButton.submit();
    }

    public void isNavigatedToResultPage(){
        waitForElementToAppear(cucumberLogo);
        Assert.assertTrue(cucumberLogo.isDisplayed());
    }
}
