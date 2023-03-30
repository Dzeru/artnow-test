package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.MainPage;
import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.pages.CatalogPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.1
 * Перейти в "Вышитые картины", произвести поиск по жанру
 * "Городской пейзаж", проверить, что картина "Трамвайный путь"
 * присутствует в выдаче.
 */
@Log4j2
@Listeners({TestFailureListener.class})
public class FirstTest extends SupportTestConfiguration {

    @Test(testName = "Check art name with the name 'Трамвайный путь'")
    public void checkArtNameTramWay() {
        log.info("Start the 1st test checkArtNameTramWay");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnGenreShowMoreButton();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkCatalogItemName("Трамвайный путь");
        log.info("Finish the 1st test checkArtNameTramWay");
    }
}