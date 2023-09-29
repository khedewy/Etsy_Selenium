package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartDirectly;
import pages.HomePage;

public class AddToCartDirectlyTest extends TestBase{
    HomePage homePage;
    AddToCartDirectly add;

    @Test
    public void navigateToProducts(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("black shirts");
    }

    @Test(priority = 1)
    public void addProductToCart(){
        add = new AddToCartDirectly(driver);
        add.addProductToCart();

        Assert.assertEquals(add.getAssertionMessage()
                ,"Comfort Colors 1717 Black Unisex Tshirt mockup, mens fashion black oversized t-shirt mock up, minimalist shirt male model mock-up for POD");
    }
}
