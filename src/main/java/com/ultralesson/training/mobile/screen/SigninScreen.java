package com.ultralesson.training.mobile.screen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import com.ultralesson.training.mobile.models.User;

public class SigninScreen extends MobileScreen {

    public SigninScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public HomeScreen signin(User clint){
//        appiumDriver.findElements(MobileBy.className("android.widget.EditText")).get(0).sendKeys(clint.getEmail());
//        appiumDriver.findElements(MobileBy.className("android.widget.EditText")).get(1).sendKeys(clint.getPassword());
        appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text='LOGIN']")).click();
        return new HomeScreen(appiumDriver);

    }
}
