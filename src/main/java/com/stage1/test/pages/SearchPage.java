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
public class SearchPage extends WaitPage {


    private final List<String> textList = Arrays.asList("apple", "orange", "banana", "kiwi");

    public WebElement inputTextBox(){
       return waitForElementVisible(By.id("search-query"));
    }

    public WebElement inputButtonBox(){
        return waitForElementVisible(By.cssSelector("button.btn.btn-primary"));
    }
    public WebElement topCategoriesHeader(){
        return waitForElementVisible(By.cssSelector("div.pb-xs-1-5"));
    }

    public WebElement allCategoriesHeader(){
        return waitForElementVisible(By.cssSelector("div.panel.p-xs-2.mb-xs-4"));
    }

    public WebElement firstPopularProduct(){
        return waitForElementVisible(By.xpath("//div[starts-with(@class,'js-merch-stash-check-listing')]"));
    }

    public WebElement firstPopularProductDescription(){
        return waitForElementVisible(By.xpath("//div[starts-with(@class,'js-merch-stash-check-listing')]//p[starts-with(@class,'text-gray text-truncate')]"));
    }

    public String randomText() {
        String selectedText = textList.get(new Random().nextInt(textList.size()));
        return selectedText;
    }

}
