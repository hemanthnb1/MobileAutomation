package com.ultralesson.training.mobile.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LauncherScreen extends MobileScreen {


    By createClientAccountBtn = By.xpath("//*[@text='CREATE CLIENT ACCOUNT']");
    By createCoachAccountBtn = By.xpath("//*[@text='CREATE COACH ACCOUNT']");
    By loginBtn = By.xpath("//*[@text='Log In']");

    public LauncherScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public SignupScreen navToClientSignup() {
        appiumDriver.findElement(createClientAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToCoachSignup() {
        appiumDriver.findElement(createCoachAccountBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SignupScreen navToLogin() {
        appiumDriver.findElement(loginBtn).click();
        return new SignupScreen(appiumDriver);
    }

    public SigninScreen navToClientSignin() {
//        waits.waitForElementToBeVisible(loginBtn).click();
        screenActions.click(loginBtn);
        return new SigninScreen(appiumDriver);

    }
}

