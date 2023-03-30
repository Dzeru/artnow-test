package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
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
        log.debug("Wait for element visible for " + SupportTestConfiguration.webDriverWaitTimeout);
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementClickable(WebElement webElement) {
        log.debug("Wait for element clickable for " + SupportTestConfiguration.webDriverWaitTimeout);
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForElementToBePresent(By locator) {
        new WebDriverWait(webDriver, SupportTestConfiguration.webDriverWaitTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
