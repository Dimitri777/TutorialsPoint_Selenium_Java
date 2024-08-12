package Report;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FileUploadDownloadTests {

    WebDriver driver;
    String downloadPath = "C:\\Users\\mrx\\Downloads\\";
    String filePath = "C:\\Users\\mrx\\Desktop\\test.txt";

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
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        driver.manage().window().maximize();

    }

    @Test
    public void downloadFileTest() throws InterruptedException {

        WebElement downloadButton = driver.findElement(By.xpath("//a[@id='downloadButton']"));
        downloadButton.click();

        Thread.sleep(5000);

        File downloadedFile = new File(downloadPath + "sampleFile.jpeg");
        assertTrue(downloadedFile.exists(), "File was not downloaded.");

        downloadButton.click();
        File downloadedFile2 = new File(downloadPath + "sampleFile (1).jpeg");
        assertTrue(downloadedFile2.exists(), "File 2 was not downloaded.");
    }

    @Test
    public void uploadFileTest() {
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        uploadInput.sendKeys(filePath);

        WebElement uploadedFileText = driver.findElement(By.id("uploadFile"));
        assertTrue(uploadedFileText.isDisplayed());
        //assertTrue(uploadedFileText.getText().contains("test.txt"), "File was not uploaded correctly.");
    }
    @After
    public void tearDown() throws Exception {
        if(driver != null) {
         //   driver.quit();
        }
    }

}
