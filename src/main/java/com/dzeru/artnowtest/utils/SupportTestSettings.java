package com.dzeru.artnowtest.utils;

import com.dzeru.artnowtest.listeners.WebDriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.dzeru.artnowtest.utils.Constants.ARTNOW_BASE_URL;

public abstract class SupportTestSettings {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Properties properties = new Properties();

    public static Duration webDriverWaitTimeout;

    static {
        try {
            properties.load(Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("artnow-test.chromedriver-path"));
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverEventListener eventListener = new WebDriverEventListener();
        //driver.register(eventListener);
        var t = properties.getProperty("artnow-test.webdriver-wait-timeout");
        webDriverWaitTimeout = Duration.parse(properties.getProperty("artnow-test.webdriver-wait-timeout"));
        webDriverWait = new WebDriverWait(driver, webDriverWaitTimeout);
        driver.get(ARTNOW_BASE_URL);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}