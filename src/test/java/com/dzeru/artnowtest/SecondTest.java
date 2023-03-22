package com.dzeru.artnowtest;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.CatalogItemPage;
import com.dzeru.artnowtest.pages.CatalogPage;
import com.dzeru.artnowtest.pages.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.2
 * Перейти в "Вышитые картины", произвести поиск по жанру
 * "Городской пейзаж", открыть подробности картины "Трамвайный путь",
 * проверить, что стиль картины "Реализм".
 */
@Listeners({TestFailureListener.class})
public class SecondTest extends SupportTestConfiguration {

    @Test
    public void checkArtStyleTramWay() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Вышитые картины");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnGenreShowMoreButton();
        catalogPage.chooseGenre("Городской пейзаж");
        catalogPage.checkArtName("Трамвайный путь");
        catalogPage.clickOnArtItemByName("Трамвайный путь");
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkStyle("Реализм");
    }
}