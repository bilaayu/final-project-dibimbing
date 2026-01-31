package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TrainingPage;
import utils.ConfigReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.time.Duration;

public class SearchTraining extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    public void SearchTraining() throws InterruptedException {
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
        trainingPage.searchTraining("test100");
    }

}
