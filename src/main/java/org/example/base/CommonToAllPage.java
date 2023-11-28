package org.example.base;

import org.example.driver.DriverManager;
import org.example.driver.DriverManagerThreadLocal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonToAllPage {

    public CommonToAllPage(){
        //if u want to call before evrey method write code here and call it
        //open file ,database connection u can write code here

    }

    //waits
    //driver call
    //common funcions

    static  void implicitwaits(){
        DriverManagerThreadLocal.getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickElement(By by){
        DriverManagerThreadLocal.getdriver().findElement(by).click();
    }
    public WebElement presenceofElement(final By elementLocation){
        return new WebDriverWait(DriverManagerThreadLocal.getdriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visbilityofElement(final By elementLocation){
        return new WebDriverWait(DriverManagerThreadLocal.getdriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected void enterInput(By by,String key){
        DriverManagerThreadLocal.getdriver().findElement(by).sendKeys(key);
    }
    protected WebElement getElement(By key){
        return DriverManagerThreadLocal.getdriver().findElement(key);

    }
}
