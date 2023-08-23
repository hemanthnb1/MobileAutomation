package com.ultralesson.training.mobile.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverCreator {

    public AppiumDriver create(DesiredCapabilities desiredCapabilities) {
        Platform platform = desiredCapabilities.getPlatform();
        return switch (platform) {
            case ANDROID -> new AndroidDriver(desiredCapabilities);
            case IOS -> new IOSDriver(desiredCapabilities);
            default -> throw new RuntimeException("Missing platform!! Add platformName capability.");
        };
    }

    public AppiumDriver createDriverContext(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
//        Platform platform = desiredCapabilities.getPlatformName();
        Platform platform = desiredCapabilities.getPlatform();
        DriverManager<AppiumDriver> mobileDriverManager = getDeviceManagers().get(platform);
        URL url = serverManagerThreadLocal.get().start();
        AppiumDriver appiumDriver =
                new MobileDriverContext(mobileDriverManager).create(url, desiredCapabilities);
        appiumDriverThreadLocal.set(appiumDriver);
        return appiumDriverThreadLocal.get();
//        return new MobileDriverContext(mobileDriverManager).create(desiredCapabilities);
    }

    // Build a Device Managers Map
    public Map<Platform, DriverManager<AppiumDriver>> getDeviceManagers() {
        Map<Platform,DriverManager<AppiumDriver>> driverManagerMap = new HashMap<>();
        driverManagerMap.put(Platform.ANDROID, new AndroidDriverManager());
        driverManagerMap.put(Platform.IOS, new IOSDriverManager());
        return driverManagerMap;
    }

    public void destroy() {
        serverManagerThreadLocal.get().stop();
        appiumDriverThreadLocal.get().quit();
    }

}