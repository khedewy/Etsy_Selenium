package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class AddToCart {
    private final WebDriver driver;
    WebDriverWait wait;
    public AddToCart(WebDriver driver){
        this.driver = driver;
    }

    private final By product = By.id("listing-title-1520960234");
    private final By addToCartButton = By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full'][1]");




    public void addToCart() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(product)));
        driver.findElement(product).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        try {
            while (i1.hasNext()) {

                String ChildWindow = i1.next();
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.findElement(addToCartButton).click();
                    System.out.println("Child window closed");
                    break;

                }
            }
        }finally {
            driver.switchTo().window(parentWindow);
            driver.quit();
        }
        }

}
