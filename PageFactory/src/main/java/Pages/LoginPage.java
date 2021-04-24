package Pages;

import Utillities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#email")
    WebElement inputEmailaddress;
    @FindBy(css="#passwd")
    WebElement inputPassword;
    @FindBy(id="SubmitLogin")
    WebElement clickOnLogin;
    @FindBy(id="login_form")
    WebElement isUserOnLoginPage;
    @FindBy(className="page-heading")
    WebElement isUserOnMyAccountPage;
    @FindBy(xpath ="//div[@class='alert alert-danger']/ol/li")
    WebElement showErrorMessage;

    public boolean isUserOnLoginPage(){
        return Util.isDisplayed(isUserOnLoginPage);
    }
    public void inputEmailaddress(String email){
        Util.sendKeys(inputEmailaddress,email);
    }
    public void inputPassword(String pwd){
        Util.sendKeys(inputPassword,pwd);
    }
    public void clickOnLogin(){
        Util.click(clickOnLogin);
    }
    public boolean isUserOnMyAccountPage(){
        return Util.isDisplayed(isUserOnMyAccountPage);
    }
    public String showErrorMessage(){
        return showErrorMessage.getText();
    }
}
