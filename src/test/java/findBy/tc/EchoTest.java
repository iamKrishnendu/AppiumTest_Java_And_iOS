package findBy.tc;

import base.AppDriver;
import base.TestListener;
import findBy.po.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class EchoTest {

    @Test
    public void theApptest() throws InterruptedException {
        String input = "qavbox";
        System.out.println("Just testing the app");
        Thread.sleep(3000);
        HomePage homePage = new HomePage();
        homePage.echoBox.click();
        homePage.echoTextBox.sendKeys(input);
        homePage.echoSave.click();
        Thread.sleep(1000);

        String platform = (String)((RemoteWebDriver)AppDriver.getDriver())
                                    .getCapabilities()
                                    .getCapability("platformName");

        if(platform.equalsIgnoreCase("android")){
            Assert.assertTrue(AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='"+input+"']")).isDisplayed());
        }else
            if(platform.equalsIgnoreCase("ios")){
                Assert.assertEquals(homePage.echoSavedText.getAttribute("value"), input);
            }

    }
}
