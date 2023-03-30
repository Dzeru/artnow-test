package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.CartPage;
import com.dzeru.artnowtest.pages.CatalogItemPage;
import com.dzeru.artnowtest.pages.CatalogPage;
import com.dzeru.artnowtest.pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.5
 * Перейти в "Ювелирное искусство", добавить первое изделие в
 * корзину, проверить, что выбранный товар находится в корзине, стоимость
 * товара не изменилась.
 */
@Log4j2
@Listeners({TestFailureListener.class})
public class FifthTest extends SupportTestConfiguration {

    @Test(testName = "Add 1st item to cart")
    public void addToCart() {
        log.info("Start 5th test addToCart");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Ювелирное искусство");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnCatalogItemByNumber(1);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        String catalogItemName = catalogItemPage.getCatalogItemName();
        String catalogItemAuthor = catalogItemPage.getCatalogItemAuthor();
        String catalogItemPrice = catalogItemPage.getCatalogItemPrice();
        catalogItemPage.clickOnAddToCartButton();
        catalogItemPage.clickOnGoToCardButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkCartItemName(catalogItemName);
        cartPage.checkCartItemAuthor(catalogItemAuthor);
        cartPage.checkCartItemPrice(catalogItemPrice);
        log.info("Finish 5th test addToCart");
    }
}