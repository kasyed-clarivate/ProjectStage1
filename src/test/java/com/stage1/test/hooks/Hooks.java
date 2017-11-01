package com.stage1.test.hooks;


import com.stage1.test.configuration.WebConnect;
import com.stage1.test.step_definition.BaseStepDef;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseStepDef{


    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("Hooks");


    @After
    public void tearDown(Scenario scenario){
        LOG.info("Scenario ID :"+scenario.getId());
        LOG.info("Scenario Name :"+scenario.getName());
        LOG.info("Scenario Status :"+scenario.getStatus());
        if(scenario.isFailed() && !WebConnect.isApiTest){
            byte[] screenshot=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        if( !WebConnect.isApiTest){
             if(getDriver()!=null) {
                 // Will Check after each scenario to Reset the Page for next Scenario
                 LOG.info("In Setup after finishing one Scenario");
                 getDriver().manage().deleteAllCookies();
                 getDriver().navigate().to(baseURL);
             }
        }if(webConnect.isDriverOpen() && WebConnect.isApiTest){
            webConnect.quitDriver();
        }

    }
}
