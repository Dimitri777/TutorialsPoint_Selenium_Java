package Allerts_Frames_Windows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BrowserWindowsTests {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().window().maximize();

    }

   @Test
    public void checkTabButtonTest(){
// Store the current window handle
       String originalWindow = driver.getWindowHandle();

       WebElement newTabButton = driver.findElement(By.xpath("//button[normalize-space()='New Tab']"));
       newTabButton.click();

       // Wait for the new tab to open (WebDriverWait)
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.numberOfWindowsToBe(2));

       // Get all open windows
       Set<String> allWindows = driver.getWindowHandles();
       assertTrue("New tab did not open.", allWindows.size() > 1);

       // Switch to the new tab
       for (String windowHandle : allWindows) {
           if (!windowHandle.equals(originalWindow)) {
               driver.switchTo().window(windowHandle);
               break;
           }
       }

       // Wait until the new tab's URL is not "about:blank"
       wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));

       // Now verify the URL and title of the new tab
       String expectedUrl = "https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php";
       String actualUrl = driver.getCurrentUrl();
       assertEquals("New tab opened with unexpected URL.", expectedUrl, actualUrl);

       String expectedTitle = "Selenium Practice - Web Tables";
       String actualTitle = driver.getTitle();
       assertEquals("New tab opened with unexpected title.", expectedTitle, actualTitle);

       assertTrue("The new tab does not contain expected text.", driver.getPageSource().contains("Sample New Tab"));

       // Close the new tab and switch back to the original tab
       driver.close();
       driver.switchTo().window(originalWindow);
    }

    @Test
    public void checkNewWindowTest() throws InterruptedException {
        // Store the current window handle
        String originalWindow = driver.getWindowHandle();

        WebElement newWindowButton = driver.findElement(By.xpath("//button[normalize-space()='New Window']"));
        newWindowButton.click();

        // Wait for the new tab to open (WebDriverWait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Wait for the new window to open
        Set<String> allWindows = driver.getWindowHandles();
        assertTrue("New window did not open.", allWindows.size() > 1);

        // Switch to the new window
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait until the new tab's URL is not "about:blank"
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));

        // Optionally, verify the URL or title of the new window
        String expectedUrl = "https://www.tutorialspoint.com/selenium/practice/new-window.php";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("New window opened with unexpected URL.", expectedUrl, actualUrl);
        assertEquals(driver.getTitle(), "Selenium Practice - Web Tables");
        assertTrue(driver.getPageSource().contains("New Window"));
        assertTrue(driver.getPageSource().contains("Selenium - Automation Practice Form"));


        // Close the new window and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);

    }

    @Test
    public void checkNewWindowMessageTest(){
        String originalWindow = driver.getWindowHandle();
        WebElement newWindowMessageButton = driver.findElement(By.xpath("//button[normalize-space()='New Window Message']"));
        WebElement newWindowMessage = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']"));
        newWindowMessageButton.click();

        // Wait for the new tab to open (WebDriverWait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Wait for the new tab to open
        Set<String> allWindows = driver.getWindowHandles();
        assertTrue("New tab did not open.", allWindows.size() > 1);

        // Switch to the new tab
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait until the new tab's URL is not "about:blank"
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));

        // Optionally, verify the URL or title of the new tab
        String expectedUrl = "https://www.tutorialspoint.com/selenium/practice/new-tab-message.php";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("New tab opened with unexpected URL.", expectedUrl, actualUrl);
        assertEquals(driver.getTitle(), "Selenium Practice - Web Tables");

        // Close the new tab and switch back to the original tab
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
