package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.dto.CatalogItem;
import io.qameta.allure.Step;
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

    private final String CATALOG_ITEM_NAME_XPATH = "//*[@id=\"main_container\"]/div[3]/div[1]/h1";
    private final String CATALOG_ITEM_AUTHOR_XPATH = "//*[@id=\"main_container\"]/div[3]/div[1]/div[2]/a";
    private final String CATALOG_ITEM_PRICE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[2]/div[1]/b[2]";
    private final String STYLE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[5]/a";
    private final String ADD_TO_FAVORITE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[2]/span";
    private final String FAVORITE_COUNTER_XPATH = "//*[@id=\"FvtCnt\"]";
    private final String FAVORITE_ICON_XPATH = "/html/body/div[1]/span[6]";
    private final String ADD_TO_CART_XPATH = "//*[starts-with(@id,\"CartButton\")]";
    private final String GO_TO_CART_XPATH = "//*[@id=\"cmodal\"]/div/p/button[1]";

    @Step("Check catalog item style")
    public void checkStyle(String style) {
        WebElement styleLink = getWebDriver().findElement(By.xpath(STYLE_XPATH));
        Assert.assertEquals(styleLink.getText(), style);
    }

    @Step("Add catalog item to favorite")
    public CatalogItem addToFavorite() {
        WebElement addToFavoriteButton = getWebDriver().findElement(By.xpath(ADD_TO_FAVORITE_XPATH));
        waitForElementClickable(addToFavoriteButton);
        addToFavoriteButton.click();
        return new CatalogItem(getCatalogItemName(), getCatalogItemAuthor());
    }

    @Step("Get catalog item name")
    public String getCatalogItemName() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_NAME_XPATH)).getText();
    }

    @Step("Get catalog item author")
    public String getCatalogItemAuthor() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_AUTHOR_XPATH)).getText();
    }

    @Step("Get catalog item price")
    public String getCatalogItemPrice() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_PRICE_XPATH)).getText();
    }

    @Step("Check if catalog item name contains substring (ignore case)")
    public void checkCatalogItemNameContainsIgnoreCase(String name) {
        Assert.assertTrue(getCatalogItemName().toLowerCase().contains(name.toLowerCase()));
    }

    @Step("Check 'favorite' counter")
    public void checkFavoriteCounter(int counter) {
        WebElement favoriteCounter = getWebDriver().findElement(By.xpath(FAVORITE_COUNTER_XPATH));
        waitForElementVisible(favoriteCounter);
        Assert.assertEquals(Integer.parseInt(favoriteCounter.getText()), counter);
    }

    @Step("Click on 'favorite' icon")
    public void clickOnFavoriteIcon() {
        WebElement favoriteIcon = getWebDriver().findElement(By.xpath(FAVORITE_ICON_XPATH));
        waitForElementClickable(favoriteIcon);
        favoriteIcon.click();
    }

    @Step("Click on 'add to cart' button")
    public void clickOnAddToCartButton() {
        WebElement addToCartButton = getWebDriver().findElement(By.xpath(ADD_TO_CART_XPATH));
        waitForElementClickable(addToCartButton);
        addToCartButton.click();
    }

    @Step("Click on 'go to cart' button")
    public void clickOnGoToCardButton() {
        WebElement goToCardButton = getWebDriver().findElement(By.xpath(GO_TO_CART_XPATH));
        waitForElementVisible(goToCardButton);
        waitForElementClickable(goToCardButton);
        goToCardButton.click();
    }
}
