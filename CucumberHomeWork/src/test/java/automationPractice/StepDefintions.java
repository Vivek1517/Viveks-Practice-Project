package automationPractice;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class StepDefintions {
    WebDriver driver;
    String url = "http://automationpractice.com/index.php";

    @Before
    public void openApp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void selectByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    @Given("user is on automation practice app")
    public void userIsOnAutomationPracticeApp() {
        boolean pageStatus = driver.findElement(By.id("home-page-tabs")).isDisplayed();
        Assert.assertTrue(pageStatus);
    }

    @When("user clicks on sign in")
    public void userClicksOnSignIn() {
        driver.findElement(By.cssSelector(".login")).click();
    }

    @Then("user should be on authentication page")
    public void userShouldBeOnAuthenticationPage() {
        boolean authenticationPage = driver.findElement(By.id("login_form")).isDisplayed();
        Assert.assertTrue(authenticationPage);
    }

    @When("user enters email {string}")
    public void userEntersValidEmail(String email) {
        driver.findElement(By.cssSelector("#email")).sendKeys(email);

    }

    @And("user enters password {string}")
    public void userEntersValidPassword(String password) {
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
    }

    @And("clicks on sign in")
    public void clicksOnSignIn() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("user should navigate to my account page")
    public void userShouldNavigateToMyAccountPage() {
        String myAccount = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(myAccount,"MY ACCOUNT");
    }


    @Then("user should see a validation message {string}")
    public void userShouldSeeAValidationMessage(String error) {
        String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        boolean validationMessage = driver.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed();
        Assert.assertTrue(validationMessage);

        Assert.assertEquals(errorMessage,error);
    }

    @When("user searches for product {string} in the search field")
    public void userSearchesForProductInTheSearchField(String product) {
        driver.findElement(By.id("search_query_top")).sendKeys(product);
    }

    @And("user clicks on search")
    public void userClicksOnSearch() {
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String error) {
        /*WebElement validation = driver.findElement(By.cssSelector(".alert.alert-warning"));
        if (error.equalsIgnoreCase("validation"));*/
       /* boolean validateMessage = driver.findElement(By.cssSelector(".alert.alert-warning")).getText().contains(error);
        Assert.assertFalse(validateMessage);*/
        String actual = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
        Assert.assertEquals(error,actual.replace("\"jeans\"","jeans"));
    }
    /*@After
    public void closeBrowser(){
        driver.quit();
    }
*/
    @Then("user should navigate to the product page")
    public void userShouldNavigateToTheProductPage() {

        String pageStatus = driver.findElement(By.cssSelector(".lighter")).getText();
        Assert.assertEquals("SKIRT",pageStatus.replace("\"SKIRT\"","SKIRT"));
    }

    @When("user clicks on contact us link")
    public void userClicksOnContactUsLink() {
        driver.findElement(By.id("contact-link")).click();
    }

    @Then("user should be navigated to contact us page")
    public void userShouldBeNavigatedToContactUsPage() {
        boolean pageStatus = driver.findElement(By.className("contact-form-box")).isDisplayed();
        Assert.assertTrue(pageStatus);
    }

    @When("user selects {string}")
    public void userSelects(String subjectHeading) {
        selectByText(driver.findElement(By.cssSelector("#id_contact")),subjectHeading);
    }

    @And("user enters a message {string}")
    public void userEntersAMessage(String message) {
        driver.findElement(By.cssSelector("#message")).sendKeys(message);
    }

    @And("user clicks on send")
    public void userClicksOnSend() {
        driver.findElement(By.id("submitMessage")).click();
    }

    @Then("user should see a message {string}")
    public void userShouldSeeAMessage(String confirmation) {
        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals(confirmation,actualMessage);
    }

    @Then("user should see a error message {string}")
    public void userShouldSeeAErrorMessage(String error_message) {
        String validationMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        Assert.assertEquals(error_message,validationMessage);
    }

    @When("user enters valid email {string}")
    public void userEntersValidEmailForNewsletter(String newsletterEmail) {
        driver.findElement(By.id("newsletter-input")).sendKeys(newsletterEmail);
        driver.findElement(By.name("submitNewsletter")).click();
    }

    @Then("user should see a news letter error message {string}")
    public void userShouldSeeANewsLetterErrorMessage(String errorMessage) {
        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(errorMessage,actualMessage);
    }


    @When("user clicks on my personal information")
    public void userClicksOnMyPersonalInformation() {
        driver.findElement(By.className("icon-user")).click();
    }

    @Then("user shoud navigate to your personal information page")
    public void userShoudNavigateToYourPersonalInformationPage() {
        boolean pageStatus = driver.findElement(By.className("page-subheading")).isDisplayed();
        Assert.assertTrue(pageStatus);
    }

    @When("user enters current password {string}")
    public void userEntersCurrentPassword(String currentPassword) {
        driver.findElement(By.cssSelector("#old_passwd")).sendKeys(currentPassword);
    }

    @And("user enters new password {string}")
    public void userEntersNewPassword(String newPassword) {
        driver.findElement(By.cssSelector("#passwd")).sendKeys(newPassword);
    }

    @And("user enters in the confirmation field {string}")
    public void userEntersInTheConfirmationField(String confirmPassword) {
        driver.findElement(By.cssSelector("#confirmation")).sendKeys(confirmPassword);
    }

    @And("user clicks on save")
    public void userClicksOnSave() {
        driver.findElement(By.name("submitIdentity")).click();
    }

    @Then("user should see a succesful validation message{string}")
    public void userShouldSeeASuccesfulValidationMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
