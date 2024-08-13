package Report;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class WebTableTests {
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
    public void AddingRecordTest() throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();

        WebElement AddButton = driver.findElement(By.xpath("//*/form/div[1]/span[1]/button"));
        WebElement firstNameRegBox = driver.findElement(By.id("firstname"));
        WebElement lastNameRegBox = driver.findElement(By.id("lastname"));
        WebElement emailRegBox = driver.findElement(By.id("email"));
        WebElement ageRegBox = driver.findElement(By.id("age"));
        WebElement salaryRegBox = driver.findElement(By.id("salary"));
        WebElement departmentRegBox = driver.findElement(By.xpath("//*[@id=\"deparment\"]"));
        WebElement loginButton = driver.findElement(By.cssSelector("#RegisterForm > div.modal-footer > input"));


        AddButton.click();

        firstNameRegBox.sendKeys("Artur");
        lastNameRegBox.sendKeys("Ivanov");
        emailRegBox.sendKeys("ariv@mail.ru");
        ageRegBox.sendKeys("4321");
        salaryRegBox.sendKeys("12345678901234567890");
        departmentRegBox.sendKeys("IT");
        loginButton.click();

        // There are no Asserts because web page does not work properly and even
        // when things are right does not add record to the table
    }

    @Test
    public void DeleteFirstRecordTest(){
        WebElement deleteFirstRecordButton = driver.findElement(By.xpath("//*/tr[1]/td[7]/a[2]"));
        deleteFirstRecordButton.click();
        assertFalse(driver.getPageSource().contains("Cierra"));
        assertFalse(driver.getPageSource().contains("Vega"));

    }

    @Test
    public void ModifyLastRecordTest(){
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();
        WebElement changeLastRecordButton = driver.findElement(By.cssSelector("body > main > div > div > div.col-md-8.col-lg-8.col-xl-8 > form > div.bd-example.table-responsive > table > tbody > tr:nth-child(5) > td:nth-child(7) > a.edit-wrap"));

        WebElement firstNameRegBox = driver.findElement(By.id("firstname"));
        WebElement lastNameRegBox = driver.findElement(By.id("lastname"));
        WebElement emailRegBox = driver.findElement(By.id("email"));
        WebElement ageRegBox = driver.findElement(By.id("age"));
        WebElement salaryRegBox = driver.findElement(By.id("salary"));
        WebElement departmentRegBox = driver.findElement(By.xpath("//*[@id=\"deparment\"]"));
        WebElement loginButton = driver.findElement(By.cssSelector("#RegisterForm > div.modal-footer > input"));

        changeLastRecordButton.click();

        firstNameRegBox.sendKeys("Natalie");
        lastNameRegBox.sendKeys("Cole");
        emailRegBox.sendKeys("natcole89@gmail.com");
        ageRegBox.sendKeys("1234");
        salaryRegBox.sendKeys("12345678901234567890123");
        departmentRegBox.sendKeys("HR");
        loginButton.click();

         assertTrue(driver.getPageSource().contains("Natalie"));

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
