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

public class EditEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void editEmployeeSuccess() {
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

        By EditEmployeeButton = By.id("edit-employee-button");
        wait.until(ExpectedConditions.elementToBeClickable(EditEmployeeButton)).click();

        By confirmEmployeeButton = By.id("edit-employee-save-changes-button");
        wait.until(ExpectedConditions.elementToBeClickable(confirmEmployeeButton)).click();
    }
}
