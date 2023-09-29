package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class AddToFavorite {
    private final WebDriver driver;
    WebDriverWait wait;
    public AddToFavorite(WebDriver driver){
        this.driver = driver;
    }
    private final By product = By.id("listing-title-1520960234");
    private final By addToFavorite = By.xpath("//button[@class='wt-btn wt-btn--transparent wt-width-full wt-justify-content-center']");
    private final By doneButton = By.xpath("//button[@class='wt-btn wt-btn--primary wt-pr-md-7 wt-pl-md-7']");


    public void addToFavorite(){

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
                    driver.findElement(addToFavorite).click();
                    System.out.println("Child window closed");
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driver.findElement(doneButton).click();
                    break;

                }
            }
        }finally {
            driver.switchTo().window(parentWindow);
            driver.quit();

        }
    }

}

