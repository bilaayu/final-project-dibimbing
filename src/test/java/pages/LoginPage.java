package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // locator
    private By emailField = By.id("input-username-or-email");
    private By passwordField = By.id("input-password");
    private By rememberMeLabel = By.xpath("//label[contains(.,'Remember')]");
    private By loginButton = By.id("button-sign-in");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void login(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys(email);

        driver.findElement(passwordField).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(rememberMeLabel)).click();

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
