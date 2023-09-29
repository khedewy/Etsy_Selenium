package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("join_neu_email_field");
    private final By passwordTxt = By.id("join_neu_password_field");
    private final By signInButton = By.xpath("//button[@value='sign-in']");
    private final By AssertionMessage = By.linkText("MahmoudKhedewy");

    public void enterLoginData(String email, String password){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailTxt)));
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signInButton)));
        driver.findElement(signInButton).click();
    }

    public String getLoginAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(AssertionMessage).getText();
    }
}
