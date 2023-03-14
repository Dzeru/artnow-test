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

    private final String ART_LIST_XPATH = "//*[@id=\"sa_container\"]/div[@class=\"post\"]";

    private final String ART_AUTHOR_AND_NAME_XPATH = ".//div[@class=\"ssize\"]";

    private final String ART_LINK_XPATH = ".//a[1]";


    @Step("Click on genre 'show more' button")
    public void clickOnGenreShowMoreButton() {
        WebElement showMoreButton = getWebDriver().findElement(By.xpath(GENRE_SHOW_MORE_BUTTON_XPATH));
        waitForElementClickable(showMoreButton);
        showMoreButton.click();
    }

    @Step("Choose genre")
    public void chooseGenre(String genre) {
        WebElement genreItemList = getWebDriver().findElement(By.xpath(String.format(GENRE_ITEM_XPATH_TEMPLATE, genre)));
        waitForElementClickable(genreItemList);
        genreItemList.click();
        WebElement applyGenreButton = getWebDriver().findElement(By.xpath(APPLY_GENRE_BUTTON_XPATH));
        waitForElementClickable(applyGenreButton);
        applyGenreButton.click();
        try { Thread.sleep(5000);} catch(InterruptedException e) { System.out.println("f");}
    }

    @Step("Check art name")
    public void checkArtName(String artName) {
        List<WebElement> arts = getWebDriver().findElements(By.xpath(ART_LIST_XPATH));
        boolean isArtNamePresent = false;
        for (WebElement art : arts) {
            WebElement authorAndName = art.findElement(By.xpath(ART_AUTHOR_AND_NAME_XPATH));
            if (authorAndName.getText().contains(artName)) {
                isArtNamePresent = true;
            }
        }
        Assert.assertTrue(isArtNamePresent);
    }

    @Step("Click on art item")
    public void clickOnArtItem(String artName) {
        List<WebElement> arts = getWebDriver().findElements(By.xpath(ART_LIST_XPATH));
        for (WebElement art : arts) {
            WebElement authorAndName = art.findElement(By.xpath(ART_AUTHOR_AND_NAME_XPATH));
            if (authorAndName.getText().contains(artName)) {
                waitForElementClickable(authorAndName);
                authorAndName.click();
            }
        }
    }
}
