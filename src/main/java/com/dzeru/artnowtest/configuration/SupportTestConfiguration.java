package com.dzeru.artnowtest.configuration;

import com.dzeru.artnowtest.utils.Browser;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
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
        log.info("Start setup");
        var systemBrowser = System.getProperty("artnow-test.browser");
        var browser = null == systemBrowser || systemBrowser.isBlank() ? Browser.valueOf(properties.getProperty("artnow-test.browser")) : Browser.valueOf(systemBrowser);
        if (browser.equals(Browser.CHROME)) {
            System.setProperty(CHROME_DRIVER_PROPERTY, properties.getProperty("artnow-test.driver.path.chrome"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(REMOTE_ALLOW_ORIGINS_OPTION);
            driver = new ChromeDriver(chromeOptions);
            log.info("Chosen browser: Chrome");
        }
        if (browser.equals(Browser.FIREFOX)) {
            System.setProperty(FIREFOX_DRIVER_PROPERTY, properties.getProperty("artnow-test.driver.path.firefox"));
            driver = new FirefoxDriver();
            log.info("Chosen browser: Firefox");
        }

        driver.manage().window().maximize();
        webDriverWaitTimeout = Duration.parse(properties.getProperty("artnow-test.webdriver-wait-timeout"));
        webDriverWait = new WebDriverWait(driver, webDriverWaitTimeout);
        var baseUrl = properties.getProperty("artnow-test.base-url");
        driver.get(baseUrl);
        log.info("webDriverWaitTimeout = " + webDriverWaitTimeout);
        log.info("baseUrl = " + baseUrl);
        log.info("Finish setup");
    }

    @AfterMethod
    public void close() {
        log.info("Driver quit");
        driver.quit();
    }
}