package com.stage1.test.configuration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActionsPage {

    @Autowired
    private WebConnect webConnect;

    public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
        new Actions(webConnect.getDriver()).dragAndDrop(dragElement, dropElement).build().perform();
    }

    public void rightClick(WebElement element) {
        new Actions(webConnect.getDriver()).contextClick(element).build().perform();
    }

    public void keyPress(Keys key) {
        new Actions(webConnect.getDriver()).sendKeys(key).build().perform();
    }

    public void doubleClick(WebElement element) {
        new Actions(webConnect.getDriver()).doubleClick(element).build().perform();
    }

    public void mouseOver(WebElement element) {
        new Actions(webConnect.getDriver()).moveToElement(element).build().perform();
    }

}
