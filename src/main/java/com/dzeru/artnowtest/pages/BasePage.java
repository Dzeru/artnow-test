package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage() {}

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    protected void waitForElementVisible(WebElement webElement) {
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementClickable(WebElement webElement) {
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
