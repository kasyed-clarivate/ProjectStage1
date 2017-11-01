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

    /**
     * This Action class related dragAndDrop method moves an element from one location and drop it to other.
     *
     * @param dragElement,dropElement
     * @return void
     */
    public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
        new Actions(webConnect.getDriver()).dragAndDrop(dragElement, dropElement).build().perform();
    }

    /**
     * This Action class related rightClick method opens the context menu.
     *
     * @param element
     * @return void
     */
    public void rightClick(WebElement element) {
        new Actions(webConnect.getDriver()).contextClick(element).build().perform();
    }

    /**
     * This Action class related keyPress method gets any key and act accordingly.
     *
     * @param key
     * @return void
     */
    public void keyPress(Keys key) {
        new Actions(webConnect.getDriver()).sendKeys(key).build().perform();
    }

    /**
     * This Action class related doubleClick method clicks double one after another.
     *
     * @param element
     * @return void
     */
    public void doubleClick(WebElement element) {
        new Actions(webConnect.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * This Action class related mouseOver method hovers over the given element.
     *
     * @param element
     * @return void
     */
    public void mouseOver(WebElement element) {
        new Actions(webConnect.getDriver()).moveToElement(element).build().perform();
    }

}
