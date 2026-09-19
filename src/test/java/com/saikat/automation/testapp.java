package com.saikat.automation;


import io.qameta.allure.AllureId;
import io.qameta.allure.seleniumbidi.AllureWebDriverBiDi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * ============================================================================
 * Class Name : testapp
 * Description:
 *
 * @author Saikat Das
 * @version 1.0
 * @since 9/18/2026
 * ============================================================================
 */
public class testapp {
    private WebDriver driver;
    private AllureWebDriverBiDi bidi;

//    private static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static ThreadLocal<AllureWebDriverBiDi> bidi = new ThreadLocal<>();

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
    @AllureId("111")
    public void loginPageTitleIsCorrect() {
        try {
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
        }finally {
            bidi.close();
        }
    }


    @Test
    @AllureId("112")
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
