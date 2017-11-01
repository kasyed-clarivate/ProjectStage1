package com.stage1.test.step_definition;

import com.stage1.test.pages.DressPage;
import com.stage1.test.pages.DropDownMenu;
import com.stage1.test.pages.ProductPage;
import com.stage1.test.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class UISteps extends BaseStepDef{

    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("UISteps");

    @Autowired
    SearchPage searchPage;

    @Autowired
    DropDownMenu dropDownMenu;

    @Autowired
    DressPage dressPage;

    @Autowired
    ProductPage productPage;

    String searchText = "Craft";
    String productText="";


    @Given("^John is viewing the Etsy landing page$")
    public void John_is_viewing_the_etsy_landing_pages() throws Throwable {
       LOG.info("John is viewing the Etsy landing page");
       mainPageOpen();

    }

    @When("^he searches for a product from the input box$")
    public void he_searches_for_a_product_from_the_input_box() throws Throwable {
       LOG.info("he searches for the text "+searchText+" a product from the input box");
       searchPage.inputTextBox().sendKeys(searchText);
       searchPage.inputButtonBox().submit();
    }

    @Then("^the result should be displayed$")
    public void the_result_should_be_displayed() throws Throwable {
       LOG.info("the result should be displayed");
       assertThat(searchPage.topCategoriesHeader().getText(), containsString(searchText));
       assertThat(searchPage.allCategoriesHeader().getText(), containsString(searchText));
    }

    @When("^he chooses clothing and dresses from drop-down menu$")
    public void he_chooses_clothing() throws Throwable {
        LOG.info("he chooses clothing and dresses from drop-down menu");
        dropDownMenu.moveToClothingDropdown();
        dropDownMenu.womenDresses().click();
      }

    @Then("^the breadcrumb for \"(.*)\" should be displayed$")
    public void the_breadcrumb_for_dresses_should_be_displayed(String item) throws Throwable {
        LOG.info("the breadcrumb for dresses should be displayed");
        assertThat(dressPage.breadcrumbDressPage().getText(), containsString(item));
    }

    @When("^he clicks on first popular product icon$")
    public void he_clicks_on_first_popular_product_icon() throws Throwable {
        LOG.info("he clicks on first popular product icon");
        productText=searchPage.firstPopularProductDescription().getText().trim();
        System.out.println("ProductDes :"+productText);
        searchPage.firstPopularProduct().click();
    }

    @Then("^the same product item description should be displayed on Product page$")
    public void the_same_product_item_description_should_be_displayed() throws Throwable {
        LOG.info("the same product item description should be displayed on Product page");
        String actualProdDesc=productPage.productListingDescription().getText().trim();
        System.out.println("actualProductDes :"+actualProdDesc);
        assertThat(actualProdDesc, containsString(productText));
    }




}
