package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    public static WebDriver driver;
    public static String url = "http://automationpractice.com/index.php";
    public static String gridURL = "https://vsalgaonkar79:e4042560-4b12-42b6-9d44-54fbe178d0f3@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static String browserType = "chrome";

    public void openBrowser(String browser, String app){
        switch (browser){
            case "chrome":
                if(browser.equalsIgnoreCase("chrome"))
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(app);
                break;
            case "firefox":
                if(browser.equalsIgnoreCase("firefox"))
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(app);
                break;
            case "remote":
                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "89.0");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    driver = new RemoteWebDriver(new URL(gridURL),browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().window().maximize();
                driver.get(app);
        }
    }

    /*public void openBrowser(String browser, String URL){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--incognito");
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().window().maximize();
        driver.get(URL);
    }*/

    public void closeBrowser(){
        driver.quit();
    }

}
