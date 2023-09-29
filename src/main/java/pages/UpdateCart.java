package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateCart {
    private final WebDriver driver;
    Select select;
    WebDriverWait wait;
    public UpdateCart(WebDriver driver){
        this.driver = driver;
    }

    private final By AddToCartButton = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[9]/div[2]/div[11]/div[1]/div/div/ol/li[1]/div/div/div[1]/span[1]/form/button/span[2]");
    private final By style = By.id("wt-cart-select-style");
    private final By size = By.id("wt-cart-select-size");
    private final By saveButton = By.xpath("//*[@id=\"cart-edit-panel-overlay\"]/div/button[2]");
    private final By AssertionMessage = By.xpath("//a[@class='wt-text-link-no-underline wt-text-title']");
    private final By quantityList = By.name("listing-quantity");
    private final By deleteItem = By.xpath("//span[@class='wt-btn wt-btn--small wt-btn--transparent']");
    private final By deleteItemAssertion = By.xpath("//*[@id=\"checkout\"]/div[2]/div[4]/div[2]/div/h1");



    public void addToCart() throws InterruptedException {
        driver.findElement(AddToCartButton).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(style)));
        select = new Select(driver.findElement(style));
        select.selectByIndex(2);
        select = new Select(driver.findElement(size));
        select.selectByIndex(1);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButton)));
        Thread.sleep(1000);
        driver.findElement(saveButton).click();
    }

    public void updateQuantity() throws InterruptedException {
        Thread.sleep(1000);
        select = new Select(driver.findElement(quantityList));
        select.selectByIndex(2);
    }

    public String getAssertionMessage() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(AssertionMessage).getText();
    }

    public void deleteItem() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(deleteItem).click();
    }

    public String getDeleteItemAssertionMessage() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(deleteItemAssertion).getText();
    }

}
