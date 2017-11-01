package com.stage1.test.step_definition;

import com.stage1.test.configuration.WebConnect;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:cucumber.xml")
public class BaseStepDef {

    @Autowired
    protected WebConnect webConnect;

    protected static boolean isApiTest=false;

    protected Response response;
    protected ValidatableResponse validatableResponse;
    protected RequestSpecification request;

    @Value("${webdriver.base.url}")
    protected String baseURL;

    public WebDriver getDriver(){
        return webConnect.getDriver();
    }

    public void mainPageOpen(){
        getDriver().navigate().to(baseURL);
    }

    protected void apiSetup(){
        RestAssured.baseURI=baseURL;
    }
    protected void apiSetSearchBasePath(){
        RestAssured.basePath="/uk";
    }
    protected void apiSetCategoryBasePath(){
        RestAssured.basePath="/uk/c/jewelry-and-accessories";
    }

    protected void apiSetProdListingBasePath(){
        RestAssured.basePath="/uk/listing/176977353/funny-mothers-day-card-anniversary-card";
    }

}
