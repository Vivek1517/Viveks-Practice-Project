package StepDefinitions;

import Pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BasePage {
    @Before
    public void getBrower(){
        openBrowser(browserType, url);
    }
    @After
    public void quitBrowser(){
        closeBrowser();
    }
}
