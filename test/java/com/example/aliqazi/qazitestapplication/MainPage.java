package com.example.aliqazi.qazitestapplication;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by Ali.Qazi on 10/31/2017.
 */

public class MainPage extends BasePage {

    private String songsButton = "com.reverbnation.artistapp.i1324422:id/songs_button";

    private String photosAndVideosButton = "com.reverbnation.artistapp.i1324422:id/photos_button";

    public void clickSongsButton(AppiumDriver driver){
        try {
            if ( driver.findElement(By.id(songsButton)).isEnabled() )
            {
                driver.findElement(By.id(songsButton)).click();
            }
        }
        catch (ElementNotFoundException ex)
        {
            System.out.println("Element not found. Check the element name in DOM" + ex);
        }
    }

    public void clickPhotosAndVideosButton(AppiumDriver driver){
        try {
            if (driver.findElement(By.id(photosAndVideosButton)).isEnabled())
            {
                driver.findElement(By.id(photosAndVideosButton)).click();
            }
        }
        catch (ElementNotFoundException ex)
        {
            System.out.println("Element not found. Check the element name in DOM" + ex);
        }
    }

}
