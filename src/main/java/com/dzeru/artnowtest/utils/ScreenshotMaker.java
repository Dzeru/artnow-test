package com.dzeru.artnowtest.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotMaker {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot) SupportTestSettings.driver).getScreenshotAs(OutputType.BYTES);
    }
}
