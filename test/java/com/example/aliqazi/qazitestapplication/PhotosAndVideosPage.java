package com.example.aliqazi.qazitestapplication;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Ali.Qazi on 10/31/2017.
 */

public class PhotosAndVideosPage extends MainPage {

    private String submitButtonText ="com.reverbnation.artistapp.i1324422:id/button_submit_photo";

    public String getSubmitButtonText (AppiumDriver driver) {

        String btnText = new String();
        try
        {
            if ( driver.findElement(By.id(submitButtonText)).isEnabled() )
            {
                btnText = driver.findElement(By.id(submitButtonText)).getText();
            }
        }
        catch (ElementNotFoundException ex) {
            System.out.println("Element not found. Check DOM for correct element value. " + ex);
        }
        return btnText;
    }
}
