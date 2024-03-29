package com.dzeru.artnowtest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogPage() {
        super();
    }

    private final String GENRE_SHOW_MORE_BUTTON_XPATH = "//*[@id=\"genrebox\"]/span[1]/span[1]";

    private final String GENRE_ITEM_XPATH_TEMPLATE = "//*[@id=\"genrebox\"]/div/label[contains(text()[1],'%s')]";

    private final String APPLY_GENRE_BUTTON_XPATH = "//*[@id=\"applymsg\"]";

    private final String ART_CONTAINER_XPATH = "//*[@id=\"sa_container\"]";
    private final String ART_LIST_XPATH = "//*[@id=\"sa_container\"]/div[@class=\"post\"]";

    private final String ART_AUTHOR_AND_NAME_XPATH = ".//div[@class=\"ssize\"]";

    @Step("Click on genre 'show more' button")
    public CatalogPage clickOnGenreShowMoreButton() {
        WebElement showMoreButton = getWebDriver().findElement(By.xpath(GENRE_SHOW_MORE_BUTTON_XPATH));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
        return this;
    }

    @Step("Choose genre")
    public CatalogPage chooseGenre(String genre) {
        WebElement genreItemList = getWebDriver().findElement(By.xpath(String.format(GENRE_ITEM_XPATH_TEMPLATE, genre)));
        waitForElementClickable(genreItemList);
        genreItemList.click();
        WebElement applyGenreButton = getWebDriver().findElement(By.xpath(APPLY_GENRE_BUTTON_XPATH));
        waitForElementClickable(applyGenreButton);
        applyGenreButton.click();
        return this;
    }

    @Step("Check catalog item name")
    public CatalogPage checkCatalogItemName(String catalogItemName) {
        waitForElementToBePresent(By.xpath(ART_LIST_XPATH));
        List<WebElement> arts = getWebDriver().findElements(By.xpath(ART_LIST_XPATH));
        boolean isCatalogItemNamePresent = false;
        for (WebElement art : arts) {
            WebElement authorAndName = art.findElement(By.xpath(ART_AUTHOR_AND_NAME_XPATH));
            if (authorAndName.getText().contains(catalogItemName)) {
                isCatalogItemNamePresent = true;
            }
        }
        Assert.assertTrue(isCatalogItemNamePresent);
        return this;
    }

    @Step("Click on catalog item by name")
    public CatalogPage clickOnCatalogItemByName(String catalogItemName) {
        List<WebElement> arts = getWebDriver().findElements(By.xpath(ART_LIST_XPATH));
        for (WebElement art : arts) {
            WebElement authorAndName = art.findElement(By.xpath(ART_AUTHOR_AND_NAME_XPATH));
            if (authorAndName.getText().contains(catalogItemName)) {
                waitForElementClickable(authorAndName);
                authorAndName.click();
                break;
            }
        }
        return this;
    }

    @Step("Click on catalog item by number")
    public CatalogPage clickOnCatalogItemByNumber(int number) {
        List<WebElement> arts = getWebDriver().findElements(By.xpath(ART_LIST_XPATH));
        WebElement art = arts.get(number);
        waitForElementClickable(art);
        art.click();
        return this;
    }
}
