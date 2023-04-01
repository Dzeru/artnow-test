package com.dzeru.artnowtest.tests;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import com.dzeru.artnowtest.dto.CatalogItem;
import com.dzeru.artnowtest.pages.CatalogItemPage;
import com.dzeru.artnowtest.pages.CatalogPage;
import com.dzeru.artnowtest.pages.FavoritePage;
import com.dzeru.artnowtest.pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2.3
 * Перейти в “Батик”, добавить первую картину в избранное, проверить,
 * что выбранная картина сохранилась в разделе «Избранное».
 */
@Log4j2
public class ThirdTest extends SupportTestConfiguration {

    @Test(testName = "Add 1st item to 'favorites'")
    public void addItemToFavorite() {
        log.info("Start the 3rd test addItemToFavorite");
        new MainPage(driver)
                .clickOnArtCategoryShowMoreButton()
                .clickOnArtCategoryMenuItem("Батик");
        new CatalogPage(driver)
                .clickOnCatalogItemByNumber(1);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        CatalogItem catalogItem = catalogItemPage.addToFavorite();
        catalogItemPage.checkFavoriteCounter(1);
        catalogItemPage.clickOnFavoriteIcon();
        new FavoritePage(driver)
                .isItemPresentInFavorites(catalogItem.getName(), catalogItem.getAuthor());
        log.info("Finish the 3rd test addItemToFavorite");
    }
}