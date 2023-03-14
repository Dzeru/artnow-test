package com.dzeru.artnowtest;

import com.dzeru.artnowtest.listeners.TestFailureListener;
import com.dzeru.artnowtest.pages.PageObjectMain;
import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
public class FirstTest extends SupportTestConfiguration {

    @Test
    public void test1() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        pageObjectMain.clickOnArtCategoryShowMoreButton();
        pageObjectMain.clickOnArtCategoryMenuItem("Живопись");
    }

    @Test
    public void test2() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        pageObjectMain.clickOnArtCategoryShowMoreButton();
        pageObjectMain.clickOnArtCategoryMenuItem("Батик");
    }

    @Test
    public void test3() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver);
        pageObjectMain.inputStringToSearch("Жираф");
    }
}