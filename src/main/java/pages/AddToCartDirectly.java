package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartDirectly {
    private final WebDriver driver;
    WebDriverWait wait;
    public AddToCartDirectly(WebDriver driver){
        this.driver = driver;
    }

    private final By AddToCartButton =By.xpath("//button[@aria-describedby='ad-listing-title-1518179088']");
    private final By assertionMessage = By.xpath("//a[@data-title='Comfort Colors 1717 Black Unisex Tshirt mockup, mens fashion black oversized t-shirt mock up, minimalist shirt male model mock-up for POD']");

    public void addProductToCart(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AddToCartButton)));
        driver.findElement(AddToCartButton).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }
}
