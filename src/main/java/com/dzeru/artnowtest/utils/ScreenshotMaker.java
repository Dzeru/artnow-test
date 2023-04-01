package com.dzeru.artnowtest.utils;

import com.dzeru.artnowtest.configuration.SupportTestConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotMaker {

    public static byte[] takeScreenshot(){
        return ((TakesScreenshot) SupportTestConfiguration.driver).getScreenshotAs(OutputType.BYTES);
    }
}
