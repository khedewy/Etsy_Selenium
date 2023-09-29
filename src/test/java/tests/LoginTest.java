package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase {

    HomePage homePage;
    RegisterPage register;
    LoginPage loginPage;
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
    public void logOut(){
        homePage = new HomePage(driver);
        homePage.logOut();
    }

    @Test(priority = 3)
    public void navigateToLogin(){
        homePage = new HomePage(driver);
        homePage.login();
    }

    @Test(priority = 4)
    public void enterLoginData() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.registerData();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(loginPage.getLoginAssertionMessage(),"MahmoudKhedewy");
    }

}
