package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void logoutSuccess() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dibimbingqa"));

        By profileButton = By.xpath("//button[@id='menu-button-layout-desktop-menu-settings']");
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();

        By signOutButton = By.xpath("//button[normalize-space(text())='Sign out']");
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton)).click();

        wait.until(ExpectedConditions.urlContains("login"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"),
                "User gagal logout"
        );
    }
}
