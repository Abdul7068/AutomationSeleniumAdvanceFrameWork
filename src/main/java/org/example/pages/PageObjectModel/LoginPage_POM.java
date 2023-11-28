package org.example.pages.PageObjectModel;

import org.example.base.CommonToAllPage;
import org.example.driver.DriverManagerThreadLocal;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage_POM extends CommonToAllPage {

    public LoginPage_POM(){
        super();
    }
    //page locators
     By username = By.id("login-username");
     By password = By.id("login-password");
     By button = By.id("js-login-btn");
     By error = By.id("js-notification-box-msg");

     //page actions

    public void openUrl(String url){
        DriverManagerThreadLocal.getdriver().get(url);
    }
     public LoginPage_POM loginToVWOPositive() throws Exception{
         enterInput(username, PropertyReader.readkey("username"));
         enterInput(password, PropertyReader.readkey("password"));
         clickElement(button);
         //pass the control to dashboardPage
         return this;
     }


    public String loginToVWONegative() throws Exception{
        enterInput(username, "admin");
        enterInput(password, PropertyReader.readkey("password"));
        clickElement(button);
        //error message
        visbilityofElement(error);
        return getElement(error).getText();
    }

    public DashboardPage_POM afterlogin(){
         return new DashboardPage_POM();
    }



}
