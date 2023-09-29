package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HelpCenter {
    private final WebDriver driver;
    WebDriverWait wait;
    Robot robot;
    public HelpCenter(WebDriver driver){
        this.driver = driver;
    }

    private final By helpCenterLink = By.linkText("Go to Help Center");
    private final By searchBox = By.xpath("/html/body/main/section/header/div/div/div[2]/div/form/div/input");
    private final By AssertionMessage = By.xpath("//h1[@class='wt-text-title-03 wt-mt-xs-4 wt-mb-xs-5']");


    public void navigateToHelpCenter(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(helpCenterLink)));
        driver.findElement(helpCenterLink).click();
    }

    public void AskYourQuestion(String question) throws AWTException {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBox)));
        driver.findElement(searchBox).sendKeys(question);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String getAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver.findElement(AssertionMessage).getText();
    }
}
