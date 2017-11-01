package com.example.aliqazi.qazitestapplication;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Ali.Qazi on 10/31/2017.
 */

public class SongsPage extends MainPage {

    private String songsList = "com.reverbnation.artistapp.i1324422:id/text_song_title";

    public List<WebElement> getSongsList (AppiumDriver driver)
    {
        List<WebElement> listReturn = new ArrayList<WebElement>();

        try {
            if ( !driver.findElements(By.id(songsList)).isEmpty())
            {
                listReturn = driver.findElements(By.id(songsList));
            }
            else
            {
                System.out.println("No song list returned");
            }
        }
        catch (ElementNotFoundException ex)
        {
            System.out.println("Element not found. Check DOM for correct element value. " + ex);
        }
        return listReturn;
    }
}
