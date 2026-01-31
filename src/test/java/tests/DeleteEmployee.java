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
public class DeleteEmployee extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void DeleteEmployee() throws InterruptedException {
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

        By deleteEmployeeButton = By.id("delete-employee-button");
        wait.until(ExpectedConditions.elementToBeClickable(deleteEmployeeButton)).click();

        By confirmDeleteButton = By.id("confirm-delete-button");
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
}
