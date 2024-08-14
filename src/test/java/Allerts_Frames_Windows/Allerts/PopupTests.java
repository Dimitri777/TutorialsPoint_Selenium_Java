package Allerts_Frames_Windows.Allerts;

import Allerts_Frames_Windows.Allerts.PopupPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.Alert;

public class PopupTests {

    WebDriver driver;
    PopupPage popupPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().window().maximize();
        popupPage = new PopupPage(driver);
    }

    @Test
    public void testSimpleAlert() {
        popupPage.clickAlertButton();
        Alert alert = popupPage.waitForAlert();
        String alertText = alert.getText();
        assertEquals("Hello world!", alertText);
        popupPage.acceptAlert();
    }

    @Test
    public void testDelayedAlert() {
        popupPage.clickDelayedAlertButton();
        Alert alert = popupPage.waitForAlert();
        String alertText = alert.getText();
        assertEquals("Hello just appeared", alertText);
        popupPage.acceptAlert();
    }

    @Test
    public void testConfirmBox() {
        popupPage.clickConfirmButton();
        Alert alert = popupPage.waitForAlert();
        String alertText = alert.getText();
        assertEquals("Press a button!", alertText);
        popupPage.acceptAlert();
        popupPage.clickConfirmButton();
        assertEquals("Press a button!", alertText);
        popupPage.dismissAlert();
        // Для подтверждения, можно использовать dismissAlert() для отказа
    }

    @Test
    public void testPromptBox() {
        popupPage.clickPromptButton();
        Alert alert = popupPage.waitForAlert();
        String alertText = alert.getText();
        assertEquals("What is your name?", alertText);
        popupPage.sendTextToPrompt("Test input");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
