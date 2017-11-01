package com.stage1.test.step_definition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class APISteps extends BaseStepDef {

    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("APISteps");

    String searchString="craft";

    @Given("John has search-string to search for search service")
    public void John_has_search_string_to_search_on_Search_Page(){
        apiSetup();
        request = given().param("q", searchString);
    }

    @When("he sends the search request")
    public void he_kicks_off_the_search(){
        apiSetSearchBasePath();
        response = request.when().get("/search");
    }


    @Given("John has category reference number to request")
    public void John_has_category_reference_number_to_request(){
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
        apiSetup();
        request = given().param("ref", "hp_rv");
    }

    @When("he kicks off the request with that listing reference")
    public void he_kicks_off_the_request_with_that_listing(){
        apiSetProdListingBasePath();
        response = request.when().get();
    }

    @Then("he gets OK status along with expected response for \"(.*)\" service")
    public void he_gets_status_code(String serviceName){
        validatableResponse = response.then().statusCode(200);

        if(serviceName.equalsIgnoreCase("Search")){
           assertThat(response.getBody().asString(), containsString(searchString));
        }else if(serviceName.equalsIgnoreCase("Category")){
            assertThat(response.getBody().asString(), containsString("jewelry-and-accessories"));
        }if(serviceName.equalsIgnoreCase("Product-Listing")){
            assertThat(response.getBody().asString(), containsString("Card "));
        }
    }


}