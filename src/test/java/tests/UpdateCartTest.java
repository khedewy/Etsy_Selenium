package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UpdateCart;

public class UpdateCartTest extends TestBase{
    HomePage homePage;
    UpdateCart updateCart;

    @Test
    public void navigateToProducts(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("Plain Mens Short Sleeve T-shirt Available Crew Neck, Scoop, Deep V-neck Slim Fit / Stretch Cotton Tees / Gift");
    }

    @Test(priority = 1)
    public void  addToCart() throws InterruptedException {
        updateCart = new UpdateCart(driver);
        updateCart.addToCart();
        Assert.assertEquals(updateCart.getAssertionMessage(),
                "Plain Mens Short Sleeve T-shirt Available Crew Neck, Scoop, Deep V-neck Slim Fit / Stretch Cotton Tees / Gift for Him");
    }

    @Test(priority = 2)
    public void updateCart() throws InterruptedException {
        updateCart = new UpdateCart(driver);
        updateCart.updateQuantity();
        updateCart.deleteItem();
        Assert.assertEquals(updateCart.getDeleteItemAssertionMessage(),"Your cart is empty.");
    }

}
