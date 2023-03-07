package com.dzeru.artnowtest.listeners;

import com.dzeru.artnowtest.utils.ScreenshotMaker;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        ScreenshotMaker.takeScreenshot();
    }
}