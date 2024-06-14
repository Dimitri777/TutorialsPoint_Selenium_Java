package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class CheckBoxesTests {
    WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Initiate browser driver
        driver = new FirefoxDriver();

        // adding implicit wait of 12 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
    }


    @Test
    public void CheckBoxesTest() throws Exception{
        WebElement plusOne = driver.findElement(By.xpath("//*[@id=\"bs_1\"]/span[1]"));
        WebElement plusTwo = driver.findElement(By.xpath("//*[@id=\"bs_2\"]/span[1]"));

        WebElement MainLevelOne = driver.findElement(By.id("c_bs_1"));
        WebElement MainLevelTwo = driver.findElement(By.id("c_bs_2"));

        WebElement SubLevelOne = driver.findElement(By.id("bf_l_1"));
        WebElement SubLevelTwo = driver.findElement(By.id("bf_l_1"));

        plusOne.click();
        MainLevelOne.click();


        assertTrue(MainLevelOne.isEnabled());
        assertTrue(SubLevelOne.isEnabled());
        assertTrue(SubLevelTwo.isEnabled());

    }

    @After
    public void teardown(){
       // driver.quit();
    }

}
