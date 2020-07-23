package findBy.po;

import base.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @iOSXCUITFindBy(accessibility = "Echo Box")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Echo Box']")
    public WebElement echoBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='messageInput']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='messageInput']") //text - Say something
    public WebElement echoTextBox;

    @iOSXCUITFindBy(accessibility = "messageSaveBtn")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='messageSaveBtn']")
    public WebElement echoSave;

    @iOSXCUITFindBy(accessibility = "The App")
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    public WebElement echoBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='savedMessage']")
    public WebElement echoSavedText;

}
