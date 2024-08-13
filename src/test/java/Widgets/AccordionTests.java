package Widgets;

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

import static org.junit.Assert.assertTrue;

public class AccordionTests {
        WebDriver driver;
        WebDriverWait wait;

        @Before
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

            driver = new FirefoxDriver();
            driver.get("https://www.tutorialspoint.com/selenium/practice/accordion.php");
            driver.manage().window().maximize();

        }

        @Test
        public void testAccordionFunctionality() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Клик на "What is Lorem Ipsum?"
            WebElement whatIsLoremIpsum = driver.findElement(By.xpath("//button[normalize-space()='What is Lorem Ipsum?']"));
            whatIsLoremIpsum.click();

            // Проверка, что текст отображается
            WebElement whatIsLoremIpsumContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"collapseTwentyOne\"]/div/p")));
            assertTrue("Content for 'What is Lorem Ipsum?' did not display correctly.",
                    whatIsLoremIpsumContent.getText().contains("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

            // Клик на "Why do we use it?"
            WebElement whyDoWeUseIt = driver.findElement(By.xpath("//button[normalize-space()='Why do we use it?']"));
            whyDoWeUseIt.click();

            // Проверка, что текст отображается
            WebElement whyDoWeUseItContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'It is a long established fact that a reader will b')]")));
            assertTrue("Content for 'Why do we use it?' did not display correctly.",
                    whyDoWeUseItContent.getText().contains("It is a long established fact that a reader will be distracted by the readable content"));

            // Клик на "Where can I get some?"
            WebElement whereCanIGetSome = driver.findElement(By.xpath("//*[@id=\"headingTwentyThree\"]/button"));
            whereCanIGetSome.click();

            // Проверка, что текст отображается
            WebElement whereCanIGetSomeContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'There are many variations of passages of Lorem Ips')]")));
            assertTrue("Content for 'Where can I get some?' did not display correctly.",
                    whereCanIGetSomeContent.getText().contains("There are many variations of passages of Lorem Ipsum available, but the ma"));
        }
        @After
        public void tearDown(){
            if (driver != null){
                driver.quit();
            }
        }


}
