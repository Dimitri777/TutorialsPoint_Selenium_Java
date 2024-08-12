package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class RadioButtonsTests {
    WebDriver driver;
    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Initiate browser driver
        driver = new FirefoxDriver();

        // adding implicit wait of 12 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");
        driver.manage().window().maximize();

    }

    @Test
    public void ClickYesNoButtonsTest() throws Exception{
        WebElement YesRadioButton = driver.findElement(By.xpath("//input[@value='igottwo']"));
        WebElement ImpressiveRadioButton = driver.findElement(By.xpath("//input[@value='igotthree']"));
        WebElement NoDisableRadioButton = driver.findElement(By.xpath("//div[@class='col-md-8 col-lg-8 col-xl-8']//div[5]"));

        assertTrue(YesRadioButton.isDisplayed());
        assertTrue(ImpressiveRadioButton.isDisplayed());
        assertTrue(NoDisableRadioButton.isDisplayed());

        YesRadioButton.click();
        assertTrue(YesRadioButton.isSelected());
        assertTrue(String.valueOf(driver.getPageSource().contains("You have checked Yes")), true);

        ImpressiveRadioButton.click();
        assertTrue(ImpressiveRadioButton.isSelected());
        assertTrue(String.valueOf(driver.getPageSource().contains("You have checked Impressive")), true);

        YesRadioButton.click();
        assertTrue(YesRadioButton.isSelected());
        assertTrue(String.valueOf(driver.getPageSource().contains("You have checked Yes")), true);

        NoDisableRadioButton.click();
        assertFalse(NoDisableRadioButton.isSelected());
        assertTrue(NoDisableRadioButton.isEnabled());

    }


    @After
    public void teardown() throws Exception{
        driver.quit();
    }
}
