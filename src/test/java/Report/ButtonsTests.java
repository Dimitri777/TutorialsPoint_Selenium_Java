package Report;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ButtonsTests {
    WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Initiate browser driver
        driver = new FirefoxDriver();

        // adding implicit wait of 12 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        driver.manage().window().maximize();
    }


    @Test
    public void TestsOfButtons() throws Exception{
        WebElement ClickMeButton = driver.findElement(By.xpath("//button[contains(text(), 'Click Me')]"));
        WebElement RightClickMeButton = driver.findElement(By.xpath("//button[contains(text(), 'Right Click Me')]"));
        WebElement DoubleClickMeButton = driver.findElement(By.xpath("//button[contains(text(), 'Double Click Me')]"));

        Actions actions = new Actions(driver);

        ClickMeButton.click();
        actions.contextClick(RightClickMeButton).perform(); // Right click
        actions.doubleClick(DoubleClickMeButton).perform(); // Double click


        assertTrue(String.valueOf(driver.getPageSource().contains("You have done a dynamic click")), true);
        assertTrue(String.valueOf(driver.getPageSource().contains("You have Double clicked")), true);
    }

    @After
    public void teardown(){
        driver.quit();
    }

}



