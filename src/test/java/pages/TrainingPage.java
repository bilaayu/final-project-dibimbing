package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainingPage {

    WebDriver driver;
    WebDriverWait wait;

    // ===== LOCATORS =====

    // menu sidebar
    private By trainingMenu = By.xpath("//div[p[normalize-space()='Training']]");

    // action
    private By addTrainingButton = By.id("add-training-button");

    // search
    private By searchTrainingInput = By.id("search-training-input");

    // detail link (row pertama)
    private By detailTrainingButton = By.id("button-detail-training-0");

    public TrainingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===== ACTIONS =====

    public void openTrainingMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(trainingMenu)).click();
    }

    public void clickAddTraining() {
        wait.until(ExpectedConditions.elementToBeClickable(addTrainingButton)).click();
    }

    public void searchTraining(String trainingName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTrainingInput))
                .clear();
        driver.findElement(searchTrainingInput).sendKeys(trainingName);
    }

    public void openFirstTrainingDetail() {
        wait.until(ExpectedConditions.elementToBeClickable(detailTrainingButton)).click();
    }
}
