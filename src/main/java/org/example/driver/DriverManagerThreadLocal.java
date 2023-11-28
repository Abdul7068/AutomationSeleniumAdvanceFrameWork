package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.util.Objects;

public class DriverManagerThreadLocal {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setdriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getdriver(){
        return dr.get();
    }
    //unload
    public static void unload(){
        dr.remove();
    }

    public static void down(){
        if(Objects.nonNull(DriverManagerThreadLocal.getdriver())){
            getdriver().quit();
            unload();
        }
    }
    public static void init()throws MalformedURLException{
        if(Objects.isNull(DriverManagerThreadLocal.getdriver())){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new EdgeDriver();
            setdriver(driver);
        }
    }




}
