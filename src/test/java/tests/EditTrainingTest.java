package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TrainingPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class EditTrainingTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void editTrainingSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );

        // ✅ tunggu login sukses
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/login")
        ));

        //Navigation
        TrainingPage trainingPage = new TrainingPage(driver);
        trainingPage.openTrainingMenu();
        trainingPage.openFirstTrainingDetail();

        By editTrainingButton = By.xpath("//button[@id='update-training-button']");
        wait.until(ExpectedConditions.elementToBeClickable(editTrainingButton)).click();

        By saveChangesButton = By.xpath("//button[@id='update-training-submit-button']");
        wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton)).click();
    }
}
