package com.stage1.test.step_definition;

import static io.restassured.RestAssured.given;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class APISteps extends BaseStepDef {

    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("APISteps");

    String searchString="craft";

    @Given("John has search-string to search for search service")
    public void John_has_search_string_to_search_on_Search_Page(){
        isApiTest=true;

        apiSetup();
        request = given().param("q", searchString);
    }

    @When("he kicks off the search")
    public void he_kicks_off_the_search(){
        apiSetSearchBasePath();
        response = request.when().get("/search");
    }

    @Then("he gets (\\d+) status code")
    public void he_gets_status_code(int statusCode){
        validatableResponse = response.then().statusCode(statusCode);
    }

    @Given("John has category reference number to request")
    public void John_has_category_reference_number_to_request(){
        isApiTest=true;
        apiSetup();
        request = given().param("ref", "catnav-10855");
    }

    @When("he kicks off the request with that category reference")
    public void he_kicks_off_the_request_with_that_category(){
        apiSetCategoryBasePath();
        response = request.when().get();
    }
    @Given("John has product listing reference number to request")
    public void John_has_listing_reference_number_to_request(){
        isApiTest=true;
        apiSetup();
        request = given().param("ref", "hp_rv");
    }

    @When("he kicks off the request with that listing reference")
    public void he_kicks_off_the_request_with_that_listing(){
        apiSetProdListingBasePath();
        response = request.when().get();
    }



}