package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    protected static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setDriver(@Optional("chrome") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.etsy.com/");
        }

        else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.etsy.com/");
        }
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }
}
