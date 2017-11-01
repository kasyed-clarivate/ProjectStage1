package com.stage1.test.pages;

import com.stage1.test.configuration.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends WaitPage {

      public WebElement productListingDescription(){
        return waitForElementVisible(By.xpath("//div[@id='listing-page-cart-inner']//h1"));
    }



}
