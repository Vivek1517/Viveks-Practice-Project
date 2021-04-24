package Pages;

import Utillities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="home-page-tabs")
    WebElement verifyUserIsOnHomePage;
    @FindBy(css=".login")
    WebElement clickOnSigin;
    @FindBy(css = ".page-heading")
    WebElement isUserOnAuthenticationPage;

    public boolean verifyUserOnHomePage(){
        return Util.isDisplayed(verifyUserIsOnHomePage);
    }
    public void clickOnSigin(){
        Util.click(clickOnSigin);
    }
    public boolean isUserOnAuthenticationPage(){
        return Util.isDisplayed(isUserOnAuthenticationPage);
    }
}
