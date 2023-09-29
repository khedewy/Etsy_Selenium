package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By AccountManger = By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin header-button']");
    private final By registerButton = By.cssSelector("button.wt-btn--secondary:nth-child(2)");
    private final By logOutMenu = By.xpath("//button[@aria-describedby='ge-tooltip-label-you-menu']");
    private final By logoutButton = By.xpath("//p[text()='Sign out']");
    private final By searchBox = By.id("global-enhancements-search-query");
    private final By searchButton = By.xpath("//button[@value='Search']");


    public RegisterPage navigateToRegisterPage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AccountManger)));
        driver.findElement(AccountManger).click();
        Thread.sleep(1000);
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public void logOut(){
        driver.findElement(logOutMenu).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(logoutButton).click();
    }

    public LoginPage login(){
        driver.findElement(AccountManger).click();
        return new LoginPage(driver);
    }

    public void searchForProduct(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}
