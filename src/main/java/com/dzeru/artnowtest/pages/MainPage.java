package com.dzeru.artnowtest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage() {
        super();
    }

    private final String ART_CATEGORY_MENU_ITEM_LIST_XPATH = "//*[@id=\"left_container\"]/div/ul[2]";
    private final String ART_CATEGORY_MENU_ITEM_XPATH_TEMPLATE = ".//li/a[contains(text()[1],'%s')]";
    private final String ART_CATEGORY_SHOW_MORE_BUTTON_XPATH = "//*[@id=\"left_container\"]/div/ul[2]/li[15]/div";
    private final String GLOBAL_SEARCH_INPUT_XPATH = "//*[@id=\"MainSearchForm\"]/div/div[1]/input[3]";
    private final String GLOBAL_SEARCH_BUTTON_XPATH = "/html/body/div[1]/span[9]/form/div/div[2]/button";

    @Step("Click on art category menu item")
    public MainPage clickOnArtCategoryMenuItem(String menuItemName) {
        WebElement menuItemList = getWebDriver().findElement(By.xpath(ART_CATEGORY_MENU_ITEM_LIST_XPATH));
        WebElement menuItem = menuItemList.findElement(By.xpath(String.format(ART_CATEGORY_MENU_ITEM_XPATH_TEMPLATE, menuItemName)));
        waitForElementClickable(menuItem);
        menuItem.click();
        return this;
    }

    @Step("WRONG! Click on art category menu item")
    public MainPage clickOnArtCategoryMenuItemWrong(String menuItemName) {
        WebElement menuItemList = getWebDriver().findElement(By.xpath("//*[@id=\"leftt_container\"]/div/ul[2]"));
        WebElement menuItem = menuItemList.findElement(By.xpath(String.format(ART_CATEGORY_MENU_ITEM_XPATH_TEMPLATE, menuItemName)));
        waitForElementClickable(menuItem);
        menuItem.click();
        return this;
    }

    @Step("Click on art category 'show more' button")
    public MainPage clickOnArtCategoryShowMoreButton() {
        WebElement showMoreButton = getWebDriver().findElement(By.xpath(ART_CATEGORY_SHOW_MORE_BUTTON_XPATH));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
        return this;
    }

    @Step("Input string to search")
    public MainPage inputStringToSearch(CharSequence searchString) {
        WebElement globalSearchInput = getWebDriver().findElement(By.xpath(GLOBAL_SEARCH_INPUT_XPATH));
        waitForElementClickable(globalSearchInput);
        globalSearchInput.sendKeys(searchString);
        WebElement globalSearchButton = getWebDriver().findElement(By.xpath(GLOBAL_SEARCH_BUTTON_XPATH));
        waitForElementClickable(globalSearchButton);
        globalSearchButton.click();
        return this;
    }
}
