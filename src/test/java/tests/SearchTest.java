package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchTest extends TestBase{

    HomePage homePage;

    @Test
    public void searchForItem(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("plain mens short sleeve T-shirt");
    }
}
