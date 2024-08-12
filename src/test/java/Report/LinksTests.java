package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class LinksTests {
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
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
        driver.manage().window().maximize();
    }

    @Test
    public void UpperPageLinksTest() throws Exception {

        WebElement homeLink = driver.findElement(By.linkText("Home")); // Click on "Home" link
        WebElement homePWPULink = driver.findElement(By.linkText("HomewPWPU")); // Not used in this test
        String targetHomeUrl = "https://www.tutorialspoint.com/index.php"; // This might not be the correct target URL

        // Click on the "Home" link
        homeLink.click();

        // Save the current window handle
            String handle = driver.getWindowHandle();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            driver.switchTo().window(handle);
            driver.switchTo().window(handle);

            System.out.println();
            System.out.println(driver.getCurrentUrl());

            /*
            for (String handle : windowHandles) {
                if (!handle.equals(originalWindowHandle)) {
                    System.out.println(driver.getCurrentUrl());


                    //assertEquals("New window URL check", targetHomeUrl, currentUrl);
                    driver.switchTo().window(originalWindowHandle); // Switch back to original window
                    System.out.println(driver.getCurrentUrl());


        } catch (Exception e) {
            System.out.println("New window with expected URL not found.");
        }

        /*
        // Option 2: No new window opens and current page redirects (or unexpected behavior)
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("about:blank")) {
            System.out.println("Link might intentionally redirect to about:blank. Investigate further.");
        } else {
            // Update assertion based on actual target URL (if known)
            assertEquals("Unexpected URL after clicking Home link", targetHomeUrl, currentUrl);
        }
        */

    }

    @Test
    public void LowerLinksTest() throws Exception{
        WebElement createdLink = driver.findElement(By.xpath("//a[@id='created']"));
        WebElement noContentLink = driver.findElement(By.xpath("//a[@id='no-content']"));
        WebElement movedLink = driver.findElement(By.xpath("//a[@id='moved']"));
        WebElement badRequestLink = driver.findElement(By.xpath("//a[@id='bad-request']"));
        WebElement unauthorizedLink = driver.findElement(By.xpath("//a[@id='unauthorized']"));
        WebElement forbiddenLink = driver.findElement(By.xpath("//a[@id='forbidden']"));
        WebElement notFoundLink = driver.findElement(By.xpath("//a[@id='not-found']"));

        WebElement createdPanel = driver.findElement(By.xpath("//div[@class='create']"));
        WebElement noContentPanel = driver.findElement(By.xpath("//div[@class='nocontent']"));
        WebElement movedPanel = driver.findElement(By.xpath("//div[@class='move']"));
        WebElement badRequestPanel = driver.findElement(By.xpath("//div[@class='brequest']"));
        WebElement unauthorizedPanel = driver.findElement(By.xpath("//div[@class='authorize']"));
        WebElement forbiddenPanel = driver.findElement(By.xpath("//div[@class='bidden']"));
        WebElement notFoundPanel = driver.findElement(By.xpath("//div[@class='nfound']"));

        assertTrue(createdLink.isDisplayed());
        assertTrue(noContentLink.isDisplayed());
        assertTrue(movedLink.isDisplayed());
        assertTrue(badRequestLink.isDisplayed());
        assertTrue(unauthorizedLink.isDisplayed());
        assertTrue(forbiddenLink.isDisplayed());
        assertTrue(notFoundLink.isDisplayed());

        createdLink.click();
        assertTrue(createdPanel.isDisplayed());

        noContentLink.click();
        assertTrue(noContentPanel.isDisplayed());

        movedLink.click();
        assertTrue(movedPanel.isDisplayed());

        badRequestLink.click();
        assertTrue(badRequestPanel.isDisplayed());

        unauthorizedLink.click();
        assertTrue(unauthorizedPanel.isDisplayed());

        forbiddenLink.click();
        assertTrue(forbiddenPanel.isDisplayed());

        notFoundLink.click();
        assertTrue(notFoundPanel.isDisplayed());


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
