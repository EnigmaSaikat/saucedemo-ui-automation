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
    private WebDriver driver;
    private AllureWebDriverBiDi bidi;

    @BeforeTest
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

    @Test
    @Description("This is the test for checking the title of sauce demo application")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://www.saucedemo.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void loginPageTitleIsCorrect() {
        try {
            Assert.assertEquals(driver.getTitle(), "Swagll Labs");
        }finally {
            bidi.close();
        }
    }


    @Test
    @Description("This is the test for login with the standerd user ")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://www.saucedemo.com/")
    @Issue("AUTH-124")
    @TmsLink("TMS-457")
    public void someOtherDistinctBehavior() {
        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }finally {
            bidi.close();
        }
    }

    @AfterTest()
    public void tearDown() {
            if (driver != null) driver.quit();
    }

}
