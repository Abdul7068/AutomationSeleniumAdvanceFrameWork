package org.example.basetest;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.example.driver.DriverManagerThreadLocal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class CommonToAllTest {

    //call here to start the web driver and down the web driver

    //Who will start the webdriver

    @BeforeMethod
    protected void setUp()throws MalformedURLException {
        DriverManagerThreadLocal.init();
    }

    //Who will close the webdriver

    @AfterMethod
    protected void teardown(){
        DriverManagerThreadLocal.down();
    }
    //for takinh screenshot

    protected void takeScreenShot(String name, WebDriver driver) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    //for extent report

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File(System.getProperty("user.dir") + "images/screenshot" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(srcfile, destination_filepath);
        return destination_filepath.toString();
    }

}
