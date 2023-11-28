package org.example.basetest;

import org.example.driver.DriverManagerThreadLocal;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
}
