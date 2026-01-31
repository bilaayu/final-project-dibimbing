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

import java.time.Duration;

public class AddEmployeeTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void addEmployeeSuccess() throws InterruptedException {
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
        employeePage.clickAddEmployee();

// Form fields
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("name")
        )).sendKeys("Test Employee");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("employeeId")
        )).sendKeys("EMP001");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("email")
        )).sendKeys("test.employee@example.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("phoneNumber")
        )).sendKeys("081234567890");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("employeeRole")
        )).sendKeys("Staff");

// Gender radio (tetap XPath karena no id)
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.chakra-radio__control")
        )).click();

// Submit
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("button-add-employee-submit")
        )).click();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void addEmployeeWithEmptyField() throws InterruptedException {
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
        employeePage.clickAddEmployee();

        // Submit
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("button-add-employee-submit")
        )).click();
    }
}
