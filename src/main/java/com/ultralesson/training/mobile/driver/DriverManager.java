package com.ultralesson.training.mobile.driver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public interface DriverManager<Driver> {

    // A new driver comes to life
    Driver create(URL serverURL, DesiredCapabilities desiredCapabilities) throws MalformedURLException;
}