package tests;

import org.testng.annotations.Test;
import pages.AddToCart;
import pages.HomePage;

public class AddToCartTest extends TestBase{
    HomePage homePage;
    AddToCart add;

    @Test
    public void searchForItem(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("gold rings");
    }

    @Test(priority = 1)
    public void addProductToCart() throws InterruptedException {
        add = new AddToCart(driver);
        add.addToCart();
    }
}
