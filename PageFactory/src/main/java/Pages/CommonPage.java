package Pages;

import Utillities.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage {
    public CommonPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css=".login")
    WebElement clickOnSigin;
    @FindBy(id="contact-link")
    WebElement clickOnContactUs;
    @FindBy(id="search_query_top")
    WebElement searchProduct;

    public void clickOnSigin(){
        Util.click(clickOnSigin);
    }
    public void clickOnContactUs(){
        Util.click(clickOnContactUs);
    }
    public void searchProduct(String product){
        Util.sendKeys(searchProduct,product);
    }
}
