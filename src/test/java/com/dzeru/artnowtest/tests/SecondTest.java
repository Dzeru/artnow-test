package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.CatalogItemPage;
import com.dzeru.artnowtest.pages.CatalogPage;
import com.dzeru.artnowtest.pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.2
 * Перейти в "Вышитые картины", произвести поиск по жанру
 * "Городской пейзаж", открыть подробности картины "Трамвайный путь",
 * проверить, что стиль картины "Реализм".
 */
@Log4j2
@Listeners({TestFailureListener.class})
public class SecondTest extends SupportTestConfiguration {

    @Test(testName = "Check if art 'Трамвайный путь' has 'Реализм' style")
    public void checkArtStyleTramWay() {
        log.info("Start the 2nd test checkArtStyleTramWay");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnGenreShowMoreButton();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkCatalogItemName("Трамвайный путь");
        catalogPage.clickOnCatalogItemByName("Трамвайный путь");
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkStyle("Реализм");
        log.info("Finish the 2nd test checkArtStyleTramWay");
    }
}