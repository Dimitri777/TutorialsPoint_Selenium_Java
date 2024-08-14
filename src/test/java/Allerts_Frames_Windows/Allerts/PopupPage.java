package Allerts_Frames_Windows.Allerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupPage {

    WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='Alert']")
    WebElement alertButton;

    @FindBy(xpath = "//button[@onclick='myMessage()']")
    WebElement delayedAlertButton;

    @FindBy(xpath = "//button[@onclick='myDesk()']")
    WebElement confirmButton;

    @FindBy(xpath = "//button[@onclick='myPromp()']")
    WebElement promptButton;

    public PopupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public void clickDelayedAlertButton() {
        delayedAlertButton.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

    public void clickPromptButton() {
        promptButton.click();
    }

    public Alert waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendTextToPrompt(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
}
