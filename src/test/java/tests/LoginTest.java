package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccess() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")
        ));

        Assert.assertFalse(
                driver.getCurrentUrl().contains("/login"),
                "❌ Login gagal, masih di halaman login"
        );
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginFailWrongPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("email"),
                "wrongpassword"
        );
    }
}
