package com.stage1.test.pages;

import com.stage1.test.configuration.ActionsPage;
import com.stage1.test.configuration.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DropDownMenu extends WaitPage {

    @Autowired
    ActionsPage actionsPage;


    public WebElement clothingDropDown(){
        return waitForElementVisible(By.xpath("//span[starts-with(@id,'catnav-primary-link') and contains(text(),'Clothing & Shoes')]"));
    }

    public WebElement womenDresses(){
        return waitForElementVisible(By.xpath("//a[starts-with(@id,'catnav') and contains(text(),'Dresses')]"));
    }

    public WebElement breadcrumbDressPage(){
        return waitForElementVisible(By.xpath("//a[contains(text(),'Women's Clothing')]/..//a[starts-with(@id,'catnav') and contains(text(),'Dresses')]"));
    }

    public void moveToClothingDropdown(){
        actionsPage.mouseOver(clothingDropDown());
    }

}
