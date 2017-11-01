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

    /**
     * This simple method returns the WebElement when supplied By locator to it.
     *
     * @param by
     * @return WebElement
     */
    protected WebElement getElement(By by){
        return driver.getDriver().findElement(by);
    }

   protected WebDriver getDriver() {
        return driver.getDriver();
    }

    /**
     * This wait method returns the List of WebElements present in the DOM when supplied By locator to it.
     *
     * @param by
     * @return List<WebElement>
     */
    protected List<WebElement> waitForExpectedElements(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    /**
     * This wait method returns the List of WebElements present in the DOM when supplied By locator to it along with wait.
     *
     * @param by,int
     * @return List<WebElement>
     */
    protected List<WebElement> waitForExpectedElements(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    /**
     * This wait method returns the List of WebElements Visible to User in the DOM when supplied By locator to it.
     *
     * @param by
     * @return List<WebElement>
     */
    protected List<WebElement> waitForElementsVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return getDriver().findElements(by);
    }

    /**
     * This wait method returns the List of WebElements present in the DOM when supplied By locator to it along with wait.
     *
     * @param by
     * @return List<WebElement>
     */
    protected List<WebElement> waitForElementsVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /**
     * This wait method returns the List of WebElements present in the DOM when supplied By locator to it.
     *
     * @param by
     * @return List<WebElement>
     */
    protected WebElement waitForElementPresent(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This wait method returns the WebElement present in the DOM when supplied By locator to it along with wait in int.
     *
     * @param by,int
     * @return WebElement
     */

    protected WebElement waitForElementPresent(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This wait method returns the WebElement visible to user in the DOM when supplied By locator to it
     *
     * @param by
     * @return WebElement
     */
    protected WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    /**
     * This wait method returns the WebElement visible in the DOM when supplied By locator to it along with wait in int.
     *
     * @param by,int
     * @return WebElement
     */
    protected WebElement waitForElementVisible(final By by, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }

    /**
     * This methods navigates the browser to the given url.
     *
     * @param url
     * @return void
     */
    protected void goTo(String url) {
        getDriver().navigate().to(url);
    }

    /**
     * This method maximises the browser window.
     *
     * @return void
     */
    protected void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

}
