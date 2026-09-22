package com.saikat.automation;


import io.qameta.allure.*;
import io.qameta.allure.seleniumbidi.AllureWebDriverBiDi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.qameta.allure.SeverityLevel.CRITICAL;

/**
 * ============================================================================
 * Class Name : SauceDemoTest
 * Description:
 *
 * @author Saikat Das
 * @version 1.0
 * @since 9/18/2026
 * ============================================================================
 */
public class SauceDemoTest {
    protected WebDriver driver;
    protected AllureWebDriverBiDi bidi;

    @BeforeClass
    public void setUp() {

        FirefoxOptions firefoxOptions = new FirefoxOptions().enableBiDi();
        bidi = new AllureWebDriverBiDi()
                .logs(true)
                .network(true)
                .maxLogEntries(500)
                .maxNetworkEvents(500);

        driver = bidi.decorate(new FirefoxDriver(firefoxOptions));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }

}
