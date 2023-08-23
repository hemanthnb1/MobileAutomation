package com.ultralesson.training.mobile.driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSDriverManager implements DriverManager<AppiumDriver> {
    @Override
    public AppiumDriver create(URL serveURL, DesiredCapabilities desiredCapabilities) {
        return new IOSDriver(desiredCapabilities);
    }
}
