package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class AssignEmployeeTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void assignEmployeeSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(ConfigReader.get("base.url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")
        ));

        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.openEmployeeMenu();
        employeePage.openActionMenu();

        // Transfer button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-action='transfer']")
        )).click();

        // Plus button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("table tbody tr:first-child td:last-child button")
        )).click();

        By divisionDropdown = By.cssSelector("select[name='Select Target Division']");

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(divisionDropdown)
        );

        // Submit
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Transfer Employee']")
        )).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void assignEmployeeFail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(ConfigReader.get("base.url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")
        ));

        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.openEmployeeMenu();
        employeePage.openActionMenu();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[data-action='transfer']")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Transfer Employee']")
        )).click();
    }
}
