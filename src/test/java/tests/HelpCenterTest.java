package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpCenter;

import java.awt.*;

public class HelpCenterTest extends TestBase{

    HelpCenter center;

    @Test
    public void navigateToHelpCenter(){
        center = new HelpCenter(driver);
        center.navigateToHelpCenter();
    }

    @Test(priority = 1)
    public void AskYYourQuestion() throws AWTException {
        center = new HelpCenter(driver);
        center.AskYourQuestion("How can I use This website");
        Assert.assertTrue(center.getAssertionMessage().contains("results"));
    }
}
