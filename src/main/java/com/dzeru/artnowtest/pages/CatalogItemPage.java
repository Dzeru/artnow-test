package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.dto.CatalogItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Locale;

public class CatalogItemPage extends BasePage {

    public CatalogItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogItemPage() {
        super();
    }

    private String CATALOG_ITEM_NAME_XPATH = "//*[@id=\"main_container\"]/div[3]/div[1]/h1";
    private String CATALOG_ITEM_AUTHOR_XPATH = "//*[@id=\"main_container\"]/div[3]/div[1]/div[2]/a";
    private String CATALOG_ITEM_PRICE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[2]/div[1]/b[2]";
    private String STYLE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[5]/a";
    private String ADD_TO_FAVORITE_XPATH = "//*[@id=\"main_container\"]/div[3]/div[2]/div[2]/span";
    private String FAVORITE_COUNTER_XPATH = "//*[@id=\"FvtCnt\"]";
    private String FAVORITE_ICON_XPATH = "/html/body/div[1]/span[6]";
    private String ADD_TO_CART_XPATH = "//*[starts-with(@id,\"CartButton\")]";
    private String GO_TO_CART_XPATH = "//*[@id=\"cmodal\"]/div/p/button[1]";

    public void checkStyle(String style) {
        WebElement styleLink = getWebDriver().findElement(By.xpath(STYLE_XPATH));
        Assert.assertEquals(styleLink.getText(), style);
    }

    public CatalogItem addToFavorite() {
        WebElement addToFavoriteButton = getWebDriver().findElement(By.xpath(ADD_TO_FAVORITE_XPATH));
        waitForElementClickable(addToFavoriteButton);
        addToFavoriteButton.click();
        return new CatalogItem(getCatalogItemName(), getCatalogItemAuthor());
    }

    public String getCatalogItemName() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_NAME_XPATH)).getText();
    }

    public String getCatalogItemAuthor() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_AUTHOR_XPATH)).getText();
    }

    public String getCatalogItemPrice() {
        return getWebDriver().findElement(By.xpath(CATALOG_ITEM_PRICE_XPATH)).getText();
    }

    public void checkCatalogItemNameContainsIgnoreCase(String name) {
        Assert.assertTrue(getCatalogItemName().toLowerCase().contains(name.toLowerCase()));
    }

    public void checkFavoriteCounter(int counter) {
        WebElement favoriteCounter = getWebDriver().findElement(By.xpath(FAVORITE_COUNTER_XPATH));
        waitForElementVisible(favoriteCounter);
        Assert.assertEquals(Integer.parseInt(favoriteCounter.getText()), counter);
    }

    public void clickOnFavoriteIcon() {
        WebElement favoriteIcon = getWebDriver().findElement(By.xpath(FAVORITE_ICON_XPATH));
        waitForElementClickable(favoriteIcon);
        favoriteIcon.click();
    }

    public void clickOnAddToCartButton() {
        WebElement addToCartButton = getWebDriver().findElement(By.xpath(ADD_TO_CART_XPATH));
        waitForElementClickable(addToCartButton);
        addToCartButton.click();
    }

    public void clickOnGoToCardButton() {
        WebElement goToCardButton = getWebDriver().findElement(By.xpath(GO_TO_CART_XPATH));
        waitForElementVisible(goToCardButton);
        waitForElementClickable(goToCardButton);
        goToCardButton.click();
    }
}
