package com.ultralesson.training.mobile.driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager implements DriverManager<AppiumDriver> {
    @Override
    public AppiumDriver create(URL serverURL,DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        return new AndroidDriver(serverURL,desiredCapabilities);
    }
}