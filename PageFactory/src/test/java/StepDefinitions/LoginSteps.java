package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utillities.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    HomePage hp = new HomePage();
    LoginPage lp = new LoginPage();
    @Given("user is on automation practice")
    public void userIsOnAutomationPractice() {
        Assert.assertTrue(hp.verifyUserOnHomePage());
    }

    @When("user clicks on sign in")
    public void userClicksOnSignIn() {
        hp.clickOnSigin();
    }

    @Then("user should navigate to authentication page")
    public void userShouldNavigateToAuthenticationPage() {
        Assert.assertTrue(hp.isUserOnAuthenticationPage());
    }

    @When("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String pwd) {
        lp.inputEmailaddress(email);
        lp.inputPassword(pwd);

    }
    @And("user clicks on log in")
    public void userClicksOnLogIn() {
        lp.clickOnLogin();
    }

    @Then("user should navigate to my account page")
    public void userShouldNavigateToMyAccountPage() {
       Assert.assertTrue(lp.isUserOnMyAccountPage());
    }
    @Then("user should see an error {string}")
    public void userShouldSeeAnError(String validation_message) {
        Assert.assertEquals(lp.showErrorMessage(),validation_message);
    }


}
