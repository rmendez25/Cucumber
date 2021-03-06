package Pages;

import Utils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Google']")
    WebElement logo;

    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnK")
    WebElement searchButton;

    @FindBy(xpath = "//img[@id='wp_thbn_21']")
    WebElement cucumberLogo;

    public void isLogoVisible(){
        Assert.assertTrue(logo.isDisplayed());
    }

    public void setSearchBox(String text){
        searchBox.sendKeys(text);
    }

    public void submitBtn(){
        searchButton.submit();
    }

    public boolean isNavigatedToResultPage(){
        return cucumberLogo.isDisplayed();
    }

}
