package org.example.pages.PageObjectModel;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPage {

    DashboardPage_POM(){

    }

    By userNameOnDashboard = By.xpath("//span[@class=\"Fw(semi-bold) ng-binding\"]");

    //page actions
    public String loggedInUsername() {
        presenceofElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
