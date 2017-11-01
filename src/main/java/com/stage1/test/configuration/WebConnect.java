package com.stage1.test.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebConnect {

    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("WebConnect");

    @Value("${driverType}")
    private String driverType;

    public static RemoteWebDriver driver;
    public static boolean isApiTest=false;


    public WebDriver getDriver(){
       try {
           if (driver == null) {
               if (driverType.equalsIgnoreCase("firefox")) {
                   LOG.info("Firefox Driver is being initialized....!");
                   driver = new FirefoxDriver();
               } else if (driverType.equalsIgnoreCase("chrome")) {
                   LOG.info("Chrome Driver is being initialized....!");
                   driver = new ChromeDriver();
               } else {
                   LOG.error("No Driver Found..!");
                   throw new Exception("No Driver Found..!");

               }
           }
       }catch(Exception e){
           e.printStackTrace();
       }

        return driver;
    }


    public boolean isDriverOpen(){
       if(driver!=null) {
         return true;
       }else{
           return false;
       }
    }

   public void quitDriver(){
        driver.quit();
   }

    public void closeSetup(){
        if(driver!=null){
            quitDriver();
        }
    }

}
