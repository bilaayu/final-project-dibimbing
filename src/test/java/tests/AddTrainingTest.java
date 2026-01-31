package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TrainingPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class AddTrainingTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void addTrainingSuccess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.urlContains("/login"))
        ));

        //Navigation
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.openTrainingMenu();
        trainingPage.clickAddTraining();

// Title
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("title")
        )).sendKeys("Test Training Title");

// Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("description")
        )).sendKeys("Ini adalah deskripsi test training.");

// Checkbox (Chakra)
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("span.chakra-checkbox__control")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
// Add Training button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-training-submit-button")
        )).click();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void addTrainingWithEmptyField() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        wait.until(ExpectedConditions.and(
                ExpectedConditions.not(ExpectedConditions.urlContains("/login"))
        ));

        //Navigation
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.openTrainingMenu();
        trainingPage.clickAddTraining();

        //Add Training Button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-training-submit-button")
        )).click();
    }
}
