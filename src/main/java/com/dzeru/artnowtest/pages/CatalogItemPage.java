package com.dzeru.artnowtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CatalogItemPage extends BasePage {

    public CatalogItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogItemPage() {
        super();
    }

    private String STYLE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[5]/a";

    public void checkStyle(String style) {
        WebElement styleLink = getWebDriver().findElement(By.xpath(STYLE_XPATH));
        Assert.assertEquals(styleLink.getText(), style);
    }
}
