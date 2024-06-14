package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class TextBoxesTests {
    WebDriver driver;

    @Before
    public void setup() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Initiate browser driver
        driver = new FirefoxDriver();

        // adding implicit wait of 12 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Opening the webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
    }


    @Test
    public void FillTextBoxesAndSubmitTest() throws Exception{
        WebElement FullNameTextBox = driver.findElement(By.id("fullname"));
        WebElement EmailTextBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement CurrentAddressTextBox = driver.findElement(By.cssSelector("#address"));
        WebElement PasswordTextBox = driver.findElement(By.id("password"));
        WebElement SubmitButton = driver.findElement(By.xpath("//form/div[5]/input"));

        FullNameTextBox.sendKeys("Alex Ivanov");
        EmailTextBox.sendKeys("aliv@mail.ru");
        CurrentAddressTextBox.sendKeys("Moscow, Kremlin, 1, Russian Federation");
        PasswordTextBox.sendKeys("JamesBond007");
        SubmitButton.submit();

        Assert.assertEquals(FullNameTextBox.getText(), "");
        Assert.assertEquals(EmailTextBox.getText(), "");
        Assert.assertEquals(CurrentAddressTextBox.getText(), "");
        Assert.assertEquals(PasswordTextBox.getText(), "");

        Assert.assertTrue(SubmitButton.isDisplayed());

    }

    @After
    public void teardown(){
        driver.quit();
    }

}
