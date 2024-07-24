package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LowerLinksTests {
    WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Initiate browser driver
        driver = new FirefoxDriver();

        // adding implicit wait of 12 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Opening the webpage

    }
    
    @Test
    public void LowerPageLinksTest() throws Exception {

            driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
            driver.manage().window().maximize();

            WebElement homeLink = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
            WebElement homePWPULink = driver.findElement(By.xpath("//a[normalize-space()='HomewPWPU']"));

            WebElement createdLink = driver.findElement(By.id("created"));
            WebElement noContentLink = driver.findElement(By.id("no-content"));
            WebElement movedLink = driver.findElement(By.id("moved"));
            WebElement badRequestLink = driver.findElement(By.id("bad-request"));
            WebElement unauthorizedLink = driver.findElement(By.id("unauthorized"));
            WebElement forbiddenLink = driver.findElement(By.id("forbidden"));
            WebElement notFoundLink = driver.findElement(By.id("not-found"));

            createdLink.click();
            WebElement createdStatusTab = driver.findElement(By.xpath("//div[@class='create']"));
            assertTrue(createdStatusTab.isDisplayed());

            noContentLink.click();
            WebElement noContentLinkTab = driver.findElement(By.xpath("//div[@class='nocontent']"));
            assertTrue(noContentLinkTab.isDisplayed());

            movedLink.click();
            WebElement movedStatusTab = driver.findElement(By.xpath("//div[@class='move']"));
            assertTrue(movedStatusTab.isDisplayed());

            badRequestLink.click();
            WebElement badRequestLinkStatusTab = driver.findElement(By.xpath("//div[@class='brequest']"));
            assertTrue(badRequestLinkStatusTab.isDisplayed());

            unauthorizedLink.click();
            WebElement unauthorizedLinkStatusTab = driver.findElement(By.xpath("//div[@class='authorize']"));
            assertTrue(unauthorizedLinkStatusTab.isDisplayed());

            forbiddenLink.click();
            WebElement forbiddenLinkStatusTab = driver.findElement(By.xpath("//div[@class='bidden']"));
            assertTrue(forbiddenLinkStatusTab.isDisplayed());

            notFoundLink.click();
            WebElement notFoundLinkStatusTab = driver.findElement(By.xpath("//div[@class='nfound']"));
            assertTrue(notFoundLinkStatusTab.isDisplayed());

        }

        @After
        public void tearDown() throws Exception{
            driver.quit();
        }


}
