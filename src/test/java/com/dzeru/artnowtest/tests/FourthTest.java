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
 * 2.4
 * Ввести в поисковую строку «Жираф», проверить, что название первой картины содержит слово «Жираф».
 */
@Log4j2
@Listeners({TestFailureListener.class})
public class FourthTest extends SupportTestConfiguration {

    @Test(testName = "Search art with name containing 'Жираф'")
    public void searchGiraffe() {
        log.info("Start the 4th test searchGiraffe");
        MainPage mainPage = new MainPage(driver);
        mainPage.inputStringToSearch("Жираф");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickOnCatalogItemByNumber(1);
        CatalogItemPage catalogItemPage = new CatalogItemPage(driver);
        catalogItemPage.checkCatalogItemNameContainsIgnoreCase("Жираф");
        log.info("Finish the 4th test searchGiraffe");
    }
}