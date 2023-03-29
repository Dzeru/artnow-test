package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
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
        log.info("Wait for element visible for " + SupportTestConfiguration.webDriverWaitTimeout);
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementClickable(WebElement webElement) {
        log.info("Wait for element clickable for " + SupportTestConfiguration.webDriverWaitTimeout);
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForElementToBePresent(By locator) {
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
