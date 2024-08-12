package Report;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class BrokenLinksTests {
    WebDriver driver;

    @Before
    public void setup() throws Exception {
        // Suppress the SLF4J error (optional)
        System.setProperty("org.slf4j.nopImpl", "org.slf4j.impl.NoOpLogger");

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe"); // Replace with your path

        // Initiate browser driver
        driver = new FirefoxDriver();

        // Implicit wait is deprecated, use explicit waits instead
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Not recommended, use explicit waits

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/broken-links.php");
        driver.manage().window().maximize();
    }

    @Test
    public void checkBrokenLinksTest() throws Exception {

        WebElement brokenImageText = driver.findElement(By.xpath("//strong[normalize-space()='Broken image']"));
        WebElement brokenImage = driver.findElement(By.xpath("//img[@class='broken-img']"));
        WebElement validLinkText = driver.findElement(By.xpath("//strong[normalize-space()='Valid Link']"));
        WebElement validLink = driver.findElement(By.xpath("//a[normalize-space()='Click Here for Valid Link']"));
        WebElement brokenLinkText = driver.findElement(By.xpath("//strong[normalize-space()='Broken Link']"));
        WebElement brokenLink = driver.findElement(By.xpath("//a[normalize-space()='Click Here for Broken Link']"));


        assertFalse(driver.getCurrentUrl().isEmpty());
        assertFalse(driver.getTitle().isEmpty());
        assertFalse(driver.getPageSource().isEmpty());

        assertTrue(brokenImageText.isDisplayed());
        assertTrue(brokenImage.isDisplayed());
        assertTrue(validLinkText.isDisplayed());
        assertTrue(validLink.isDisplayed());
        assertTrue(brokenLinkText.isDisplayed());
        assertTrue(brokenLink.isDisplayed());

        validLink.click();
        assertTrue(validLink.isEnabled());

        brokenLink.click();

        // Locators for elements on https://www.tutorialspoint.com/selenium/practice/broken-link.php
        WebElement statusCodesText = driver.findElement(By.xpath("//h1[normalize-space()='Status Codes']"));
        WebElement statusCode500Text = driver.findElement(By.xpath("//h5[normalize-space()='This page returned a 500 status code.']"));
        WebElement definitionsText = driver.findElement(By.xpath("//h6[contains(text(),'For a definition and common list of HTTP status co')]"));
        WebElement goBackLink = driver.findElement(By.xpath("//a[normalize-space()='Go Back']"));

        assertEquals(driver.getTitle(), "Broken Link - Status 500");
        assertEquals(driver.getCurrentUrl(), "https://www.tutorialspoint.com/selenium/practice/broken-link.php");

        assertTrue(statusCodesText.isDisplayed());
        assertTrue(statusCode500Text.isDisplayed());
        assertTrue(definitionsText.isDisplayed());
        assertTrue(goBackLink.isDisplayed());

    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }


}
