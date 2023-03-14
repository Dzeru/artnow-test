package com.dzeru.artnowtest.configuration;

import com.dzeru.artnowtest.listeners.WebDriverEventListener;
import com.dzeru.artnowtest.utils.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.dzeru.artnowtest.utils.Constants.*;

public abstract class SupportTestConfiguration {

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
    public void setUp() throws IllegalArgumentException {
        var browser = Browser.valueOf(properties.getProperty("artnow-test.browser"));
        if (browser.equals(Browser.CHROME)) {
            System.setProperty(CHROME_DRIVER_PROPERTY, properties.getProperty("artnow-test.driver.path.chrome"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(REMOTE_ALLOW_ORIGINS_OPTION);
            driver = new ChromeDriver(chromeOptions);
        }
        if (browser.equals(Browser.FIREFOX)) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY, properties.getProperty("artnow-test.driver.path.firefox"));
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        WebDriverEventListener eventListener = new WebDriverEventListener();
        //driver.register(eventListener);
        webDriverWaitTimeout = Duration.parse(properties.getProperty("artnow-test.webdriver-wait-timeout"));
        webDriverWait = new WebDriverWait(driver, webDriverWaitTimeout);
        driver.get(ARTNOW_BASE_URL);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}