package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
public class ResendEmailEmployee extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    public void ResendEmailEmployee() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.urlContains("/login"))
        ));

        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.openEmployeeMenu();
        employeePage.openFirstEmployeeDetail();

        By ResendEmailButton = By.id("resend-email-button");
        wait.until(ExpectedConditions.elementToBeClickable(ResendEmailButton)).click();

        By ResendEmailConfirmButton = By.id("resend-email-confirm-button");
        wait.until(ExpectedConditions.elementToBeClickable(ResendEmailConfirmButton)).click();
    }
}