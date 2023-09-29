package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToFavorite;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class AddToFavoriteTest extends TestBase{
    HomePage homePage;
    AddToFavorite add;
    RegisterPage register;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        RegisterData data = new RegisterData();
        data.registerData();
        register = new RegisterPage(driver);
        register.enterRegisterData(data.email+currentTime+"@gmail.com", data.name, data.password);
        Assert.assertEquals(register.getRegisterAssertionMessage(),"MahmoudKhedewy");
    }

    @Test(priority = 2)
    public void navigateToProducts(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("gold rings");
    }

    @Test(priority = 3)
    public void addToFavorite(){
        add = new AddToFavorite(driver);
        add.addToFavorite();
    }
}
