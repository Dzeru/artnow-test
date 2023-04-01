package com.dzeru.artnowtest.listeners;

import com.dzeru.artnowtest.utils.ScreenshotMaker;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// Simple listener with onTestFailure does not attach a screenshot to the report
// https://github.com/cbeust/testng/issues/2791
public class CustomLifecycleListener implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            SimpleDateFormat screenshotTime = new SimpleDateFormat("dd.MM.yyyy'at'hh.mm.ss");
            String screenshotName = result.getName() + "_" + screenshotTime.format(new Date()) + ".png";
            Allure.addAttachment(screenshotName, new ByteArrayInputStream(ScreenshotMaker.takeScreenshot()));
        }
    }
}