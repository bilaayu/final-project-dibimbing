package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage {

    WebDriver driver;
    WebDriverWait wait;

    // ===== Navigation & Tab =====
    private By employeeMenu = By.xpath("//p[normalize-space()='Employee']");
    private By employeeListTab = By.xpath("//button[contains(.,'Employee List')]");

    // ===== Actions =====
    private By addEmployeeButton = By.id("button-add-employee");
    private By searchField = By.xpath("//input[contains(@placeholder,'Search')]");
    private By filterAngkatanDropdown = By.id("menu-button-:rm:");
    private By actionMenu = By.id("menu-button-admin-employee-action");
    private By detailEmployee = By.id("button-detail-employee-0");

    // ===== Table =====
    private By employeeTable = By.xpath("//table");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== Actions Method =====
    public void openEmployeeMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeMenu)).click();
    }

    public void openEmployeeListTab() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeListTab)).click();
    }

    public void clickAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
    }

    public void searchEmployee(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField))
                .clear();
        driver.findElement(searchField).sendKeys(keyword);
    }

    public boolean isEmployeeTableDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeTable))
                .isDisplayed();
    }

    public void openFilterAngkatan() {
        wait.until(ExpectedConditions.elementToBeClickable(filterAngkatanDropdown))
                .click();
    }

    public void openActionMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(actionMenu))
                .click();
    }

    public void openFirstEmployeeDetail() {
        wait.until(ExpectedConditions.elementToBeClickable(detailEmployee)).click();
    }
}
