package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;
import java.time.Duration;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SearchEmployee extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    public void SearchEmployee() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.urlContains("/login"))
        ));

        // Navigation
        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.openEmployeeMenu();
        employeePage.searchEmployee("EMP001");
    }

}
