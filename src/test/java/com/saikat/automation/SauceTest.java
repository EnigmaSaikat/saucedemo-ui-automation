package com.saikat.automation;

import io.qameta.allure.*;
import io.qameta.allure.testfilter.TestPlanV1_0;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

/**
 * ============================================================================
 * Class Name : SauceTest
 * Description:
 *
 * @author Saikat Das
 * @version 1.0
 * @since 9/22/2026
 * ============================================================================
 */
public class SauceTest extends SauceDemoTest {
    @Test
    @Description("This is the test for checking the title of sauce demo application")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://www.saucedemo.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Epic("Web interface")
    @Feature("Essential features")
    @Story("Authentication")
    public void loginPageTitleIsCorrect() {
        try {
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
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
    @Epic("Web interface")
    @Feature("Essential features")
    @Story("Authentication")
    public void someOtherDistinctBehavior() {
        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
        }finally {
            bidi.close();
        }
    }
}
