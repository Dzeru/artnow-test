package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
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
public class SecondTest extends SupportTestConfiguration {

    @Test(testName = "Check if art 'Трамвайный путь' has 'Реализм' style")
    public void checkArtStyleTramWay() {
        log.info("Start the 2nd test checkArtStyleTramWay");
        MainPage mainPage = new MainPage(driver)
                .clickOnArtCategoryShowMoreButton()
                .clickOnArtCategoryMenuItem("Вышитые картины");
        new CatalogPage(driver)
                .clickOnGenreShowMoreButton()
                .chooseGenre("Городской пейзаж")
                .checkCatalogItemName("Трамвайный путь")
                .clickOnCatalogItemByName("Трамвайный путь");
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkStyle("Реализм");
        log.info("Finish the 2nd test checkArtStyleTramWay");
    }
}