package com.dzeru.artnowtest.pages;

import com.dzeru.artnowtest.dto.CatalogItem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FavoritePage extends BasePage {

    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    public FavoritePage() {
        super();
    }
    private final String FAVORITE_ITEM_XPATH = "//*[@id=\"sa_container\"]/div[@class=\"post\"]";
    private final String ART_AUTHOR_AND_NAME_XPATH = ".//div[@class=\"ssize\"]";

    @Step("Check if item is present in favorites")
    public void isItemPresentInFavorites(String name, String author) {
        List<WebElement> favoriteItems = getWebDriver().findElements(By.xpath(FAVORITE_ITEM_XPATH));
        var isItemPresent = false;
        for (WebElement favoriteItem : favoriteItems) {
            WebElement authorAndName = favoriteItem.findElement(By.xpath(ART_AUTHOR_AND_NAME_XPATH));
            String authorAndNameText = authorAndName.getText();
            if (authorAndNameText.contains(name) && authorAndNameText.contains(author)) {
                isItemPresent = true;
            }
        }
        Assert.assertTrue(isItemPresent);
    }

}
