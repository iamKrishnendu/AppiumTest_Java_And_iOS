package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        AppiumServer.Start();
        //System.out.println("From parameter attr" + platformName);
        String Platform = result.getMethod().getXmlTest().getLocalParameters().get("platform");

        if(Platform.contains("android"))
        {
            try {
                AppFactory.Android_LaunchApp();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else
            if(Platform.contains("ios")){
                try {
                    AppFactory.iOS_LaunchApp();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        tearDown();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        tearDown();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        tearDown();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public void tearDown(){
        AppDriver.getDriver().quit();
        AppiumServer.Stop();
    }
}
