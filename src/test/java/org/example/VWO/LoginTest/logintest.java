package org.example.VWO.LoginTest;

import org.assertj.core.api.Assertions;
import org.example.basetest.CommonToAllTest;
import org.example.pages.PageObjectModel.DashboardPage_POM;
import org.example.pages.PageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class logintest extends CommonToAllTest {



    @Test(priority = 1)
    public void testLoginNegative() throws Exception {

        //How to enter username , password and enter to dashboard and verify

        LoginPage_POM pagepom = new LoginPage_POM();
        pagepom.openUrl(PropertyReader.readkey("url"));
        String error = pagepom.loginToVWONegative();
        System.out.println("Error message:-" +error);
        Assertions.assertThat(error).isNotNull().isNotBlank().contains(PropertyReader.readkey("error_message"));


    }


    @Test(groups = {"QA"})
    public void testLoginPositive() throws Exception {

        //How to enter username , password and enter to dashboard and verify

        LoginPage_POM pagepom = new LoginPage_POM();
        pagepom.openUrl(PropertyReader.readkey("url"));
        pagepom.loginToVWOPositive();
        DashboardPage_POM dashboardPagePom = pagepom.afterlogin();
        String expected_username = dashboardPagePom.loggedInUsername();
        System.out.println("name on dashboard:-" +expected_username);
        Assertions.assertThat(expected_username).isNotNull().isNotBlank().contains(PropertyReader.readkey("Expected_username"));
    }


}
