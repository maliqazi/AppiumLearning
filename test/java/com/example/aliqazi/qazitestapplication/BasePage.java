package com.example.aliqazi.qazitestapplication;

import org.junit.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by Ali.Qazi on 10/31/2017.
 */

public class BasePage {

    AppiumDriver driver;

    private String serverURL = new String();
    private String targetDeviceName = new String();
    private String versionNumber = new String();
    private String targetPlatformName = new String();
    private String targetAppPackage = new String();
    private String targetAppActivity = new String();

    public String getServerURL(){
        return serverURL;
    }
    public void setServerURL(String value){
        serverURL = value;
    }

    public String getTargetDeviceName(){
        return targetDeviceName;
    }
    public void setTargetDeviceName(String value){
        targetDeviceName = value;
    }

    public String getVersionNumber(){
        return versionNumber;
    }
    public void setVersionNumber(String value){
        versionNumber = value;
    }

    public String getTargetPlatformName(){
        return targetPlatformName;
    }
    public void setTargetPlatformName(String value){
        targetPlatformName = value;
    }

    public String getTargetAppPackage(){
        return targetAppPackage;
    }
    public void setTargetAppPackage(String value) {
        targetAppPackage = value;
    }

    public String getTargetAppActivity(){
        return targetAppActivity;
    }
    public void setTargetAppActivity(String value){
        targetAppActivity = value;
    }

    public AndroidDriver setCapabilities(AppiumDriver driver) throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", targetDeviceName);

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, versionNumber);

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", targetPlatformName);

        // Set android appPackage desired capability.
        capabilities.setCapability("appPackage", targetAppPackage);

        // Set android appActivity desired capability.
        capabilities.setCapability("appActivity", targetAppActivity);

        // Set appium server address and port number in URL string.
        try {
            driver = new AndroidDriver(new URL(serverURL), capabilities);
        }
        catch (Exception e) {}

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        return  (AndroidDriver)driver;

    }

}
