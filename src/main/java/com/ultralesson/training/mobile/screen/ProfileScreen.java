package com.ultralesson.training.mobile.screen;

import com.ultralesson.training.mobile.models.User;
import io.appium.java_client.AppiumDriver;

public class ProfileScreen {

    private AppiumDriver appiumDriver;

    public ProfileScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public User getProfileDetails() {


        return new User();
    }
}