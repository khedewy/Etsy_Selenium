package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private final WebDriver driver;
    WebDriverWait wait;
    public RegisterPage(WebDriver driver){
        this.driver= driver;
    }

    private final By emailTxt = By.xpath("//*[@id=\"join_neu_email_field\"]");
    private final By firstNameTxt = By.id("join_neu_first_name_field");
    private final By passwordTxt = By.id("join_neu_password_field");
    private final By registerButton = By.xpath("//button[@value='register']");
    private final By AssertionMessage = By.linkText("MahmoudKhedewy");

    public void enterRegisterData(String email, String name, String password) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(firstNameTxt).sendKeys(name);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registerButton)));
        driver.findElement(registerButton).click();
    }

    public String getRegisterAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(AssertionMessage).getText();
    }
}
