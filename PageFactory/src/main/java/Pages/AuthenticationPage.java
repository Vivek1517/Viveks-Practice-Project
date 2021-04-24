package Pages;

import Utillities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".page-heading")
    WebElement isUserOnAuthenticationPage;
    @FindBy(css="@email_create")
    WebElement inputEmailToCreateAccount;
    @FindBy(css="@SubmitCreate")
    WebElement clickONCreateAccount;

    public boolean isUserOnAuthenticationPage(){
        return Util.isDisplayed(isUserOnAuthenticationPage);
    }
    public void enterEmailToCreateAccount(String text){
        Util.sendKeys(inputEmailToCreateAccount,text);
    }
    public void clickONCreateAccount(){
        Util.click(clickONCreateAccount);
    }
}
