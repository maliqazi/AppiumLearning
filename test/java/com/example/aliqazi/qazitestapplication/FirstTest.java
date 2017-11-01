package com.example.aliqazi.qazitestapplication;

import java.net.MalformedURLException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

public class FirstTest {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        BasePage basePage = new BasePage();

        // Send parameters for device capabilities
        basePage.setServerURL("http://127.0.0.1:4723/wd/hub");
        basePage.setTargetDeviceName("XT1562");
        basePage.setVersionNumber("8.0");
        basePage.setTargetPlatformName("Android");
        basePage.setTargetAppPackage("com.reverbnation.artistapp.i1324422");
        basePage.setTargetAppActivity("com.reverbnation.artistapp.i1324422.activities.SplashActivity");
        driver = basePage.setCapabilities(driver);
    }

    @Test
    public void test1() {

        MainPage mainPage = new MainPage();
        SongsPage songsPage = new SongsPage();

        // Go to songs page
        mainPage.clickSongsButton(driver);

        // Click the title of the first song in the list
        List<WebElement> listOfSongs = songsPage.getSongsList(driver);

        //Get name of first song in list
        String titleOfSong = listOfSongs.get(0).getText();

        // The title of the first song in the list should be "Breathing a spring"
        Assert.assertEquals(titleOfSong.toString(),"Breathing a spring");
    }

    @Test
    public void test2(){

        MainPage mainPage = new MainPage();
        PhotosAndVideosPage photosAndVideosPage = new PhotosAndVideosPage();

        // Go to photos and videos page
        mainPage.clickPhotosAndVideosButton(driver);

        // Find the submit photo button and get its text
        String btnText = photosAndVideosPage.getSubmitButtonText(driver);

        // The button's text should be "Submit Photo"
        Assert.assertEquals(btnText.toString(),"Submit Photo");

    }

    @After
    public void tearDown() {
        try {
            driver.quit();
        }
        catch (Exception e)
        { }
    }
}