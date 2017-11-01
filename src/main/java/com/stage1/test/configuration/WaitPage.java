package com.stage1.test.configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WaitPage {
    private final static org.slf4j.Logger LOG= org.slf4j.LoggerFactory.getLogger("WaitPage");
    private static final int WAIT_TIME=20;

    @Autowired
    private WebConnect driver;

    protected WebElement getElement(By by){
        return driver.getDriver().findElement(by);
    }

    protected WebDriver getDriver() {
        return driver.getDriver();
    }

    protected List<WebElement> waitForExpectedElements(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    protected List<WebElement> waitForExpectedElements(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    protected List<WebElement> waitForElementsVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    protected List<WebElement> waitForElementsVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitForElementPresent(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitForElementPresent(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    protected WebElement waitForElementVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    protected void goTo(String url) {
        getDriver().navigate().to(url);
    }


    protected void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

}
