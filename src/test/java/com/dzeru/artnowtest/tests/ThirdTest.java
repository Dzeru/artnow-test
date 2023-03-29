package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.dto.CatalogItem;
import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.CatalogItemPage;
import com.dzeru.artnowtest.pages.CatalogPage;
import com.dzeru.artnowtest.pages.FavoritePage;
import com.dzeru.artnowtest.pages.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.3
 * Перейти в “Батик”, добавить первую картину в избранное, проверить,
 * что выбранная картина сохранилась в разделе «Избранное».
 */
@Listeners({TestFailureListener.class})
public class ThirdTest extends SupportTestConfiguration {

    @Test
    public void addItemToFavorite() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnArtCategoryShowMoreButton();
        mainPage.clickOnArtCategoryMenuItem("Батик");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnCatalogItemByNumber(1);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        CatalogItem catalogItem = catalogItemPage.addToFavorite();
        catalogItemPage.checkFavoriteCounter(1);
        catalogItemPage.clickOnFavoriteIcon();
        FavoritePage favoritePage = new FavoritePage(driver);
        favoritePage.isItemPresentInFavorites(catalogItem.getName(), catalogItem.getAuthor());
    }
}