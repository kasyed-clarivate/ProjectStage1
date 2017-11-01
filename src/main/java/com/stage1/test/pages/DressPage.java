package com.stage1.test.pages;

import com.stage1.test.configuration.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class DressPage extends WaitPage {

      public WebElement breadcrumbDressPage(){
        return waitForElementVisible(By.xpath("//div[@class='text-gray-lighter text-smaller']"));
    }



}
