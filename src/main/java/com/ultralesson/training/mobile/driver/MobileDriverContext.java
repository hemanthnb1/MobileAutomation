package com.ultralesson.training.mobile.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverContext {
    private DriverManager<AppiumDriver> driverManager;

    public MobileDriverContext(DriverManager<AppiumDriver> driverManager) {
        setWebDriver(driverManager);
    }

    public AppiumDriver create(URL serverURL, DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        return driverManager.create(serverURL,desiredCapabilities);
    }

    public void setWebDriver(DriverManager<AppiumDriver> driverManager) {
        this.driverManager = driverManager;

    }
}