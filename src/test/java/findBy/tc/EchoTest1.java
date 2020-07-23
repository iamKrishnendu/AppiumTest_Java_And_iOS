package findBy.tc;

import base.AppDriver;
import base.TestListener;
import findBy.po.HomePage1;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class EchoTest1 {

    @Test
    public void Test_EchoTest() throws InterruptedException {
        String input = "qavbox";
        System.out.println("Just testing the app");
        Thread.sleep(3000);
        HomePage1 homePage = new HomePage1();

        homePage.navigateToEchoBox();
        homePage.enterSomething(input);
        homePage.saveText();
        homePage.verifySavedText(input);

    }
}
