package com.dzeru.artnowtest.tests;

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
public class FirstTest extends SupportTestConfiguration {

    @Test(testName = "Check art name with the name 'Трамвайный путь'")
    public void checkArtNameTramWay() {
        log.info("Start the 1st test checkArtNameTramWay");
        new MainPage(driver)
                .clickOnArtCategoryShowMoreButton()
                .clickOnArtCategoryMenuItem("Вышитые картины");
        new CatalogPage(driver)
                .clickOnGenreShowMoreButton()
                .chooseGenre("Городской пейзаж")
                .checkCatalogItemName("Трамвайный путь");
        log.info("Finish the 1st test checkArtNameTramWay");
    }

    @Test(testName = "Check art name with the name 'Трамвайный путь' but make it failed")
    public void checkArtNameTramWayToBeFailed() {
        log.info("Start the 1st test checkArtNameTramWayToBeFailed");
        new MainPage(driver)
                .clickOnArtCategoryShowMoreButton()
                .clickOnArtCategoryMenuItem("Вышитые картины");
        new CatalogPage(driver)
                .clickOnGenreShowMoreButton()
                .chooseGenre("Городской пейзаж")
                .checkCatalogItemName("Трамвайная дорога");
        log.info("Finish the 1st test checkArtNameTramWayToBeFailed");
    }
}