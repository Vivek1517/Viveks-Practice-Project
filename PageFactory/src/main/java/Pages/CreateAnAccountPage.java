package Pages;

import Utillities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends BasePage {
    public CreateAnAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className="page-heading")
    WebElement isUserOnCreateAnAccountPage;
    @FindBy(css="#id_gender1")
    WebElement chooseTitleMr;
    @FindBy(css="#id_gender2")
    WebElement chooseTitleMrs;
    @FindBy(css="#customer_firstname")
    WebElement input1stName;
    @FindBy(css="#customer_lastname")
    WebElement inputLastName;
    @FindBy(css="#passwd")
    WebElement inputPwd;
    @FindBy(css="#days")
    WebElement selectDate;
    WebElement selectMonth;
    @FindBy(css="#years")
    WebElement selectYear;
    @FindBy(css="#address1")
    WebElement inputAddress;
    @FindBy(css="#city")
    WebElement inputCity;
    @FindBy(css="#id_state")
    WebElement selectState;
    @FindBy(css="#postcode")
    WebElement inputPostCode;
    @FindBy(css="#phone")
    WebElement inputHomeNumber;
    @FindBy(css="#phone_mobile")
    WebElement inputMobileNumber;
    @FindBy(id="submitAccount")
    WebElement clickOnRegister;
    @FindBy(css=".alert.alert-danger")
    WebElement showError;

    public String isUserOnCreateAccountPage(String actualText){
        return Util.getText(isUserOnCreateAnAccountPage);
    }
    public void selectGender(String gender, String firstName, String lastName, String password){
        if(gender.equalsIgnoreCase("Mr")){
            Util.waitTime(2);
            Util.click(chooseTitleMr);
        }
        else {
            Util.click(chooseTitleMrs);
        }
        Util.sendKeys(input1stName,firstName);
        Util.sendKeys(inputLastName,lastName);
        Util.sendKeys(inputPwd,password);
    }

    public void selectDOB(String date, String month, String year){
        Util.waitTime(2);
        Util.selectByVisibleText(selectDate,date);
        Util.selectByVisibleText(selectMonth,month);
        Util.selectByVisibleText(selectYear,year);
    }

    public void enterAddressAndContactNumber(String address, String city, String state, String postCode, String homeNo, String mobileNo){
        Util.sendKeys(inputAddress, address);
        Util.sendKeys(inputCity, city);
        Util.waitTime(2);
        Util.selectByVisibleText(selectState, state);
        Util.sendKeys(inputPostCode, postCode);
        Util.sendKeys(inputHomeNumber, homeNo);
        Util.sendKeys(inputMobileNumber, mobileNo);
    }

    public void clickOnRegister(){
        Util.click(clickOnRegister);
    }

    public String userShouldGetError(){
        return Util.getText(showError);
    }

}
