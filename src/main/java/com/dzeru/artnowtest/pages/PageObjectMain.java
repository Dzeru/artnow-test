package com.dzeru.artnowtest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectMain extends BasePage {

    public PageObjectMain(WebDriver webDriver) {
        super(webDriver);
    }

    public PageObjectMain() {
        super();
    }

    private final String ART_CATEGORY_MENU_ITEM_LIST_XPATH = "//*[@id=\"left_container\"]/div/ul[2]";
    private final String ART_CATEGORY_MENU_ITEM_XPATH_TEMPLATE = ".//li/a[contains(text()[1],'%s')]";
    private final String ART_CATEGORY_SHOW_MORE_BUTTON_XPATH = "//*[@id=\"left_container\"]/div/ul[2]/li[15]/div";


    @Step("Click on art category menu item")
    public void clickOnArtCategoryMenuItem(String menuItemName) {
        System.out.println("Getting " + menuItemName);
        WebElement menuItemList = getWebDriver().findElement(By.xpath(ART_CATEGORY_MENU_ITEM_LIST_XPATH));
        WebElement menuItem = menuItemList.findElement(By.xpath(String.format(ART_CATEGORY_MENU_ITEM_XPATH_TEMPLATE, menuItemName)));
        waitForElementClickable(menuItem);
        menuItem.click();
    }

    @Step("Click on art category 'show more' button")
    public void clickOnArtCategoryShowMoreButton() {
        WebElement showMoreButton = getWebDriver().findElement(By.xpath(ART_CATEGORY_SHOW_MORE_BUTTON_XPATH));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
    }
}
