package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

public class FirefoxTests {
        WebDriver driver;
        @Before
        public void setUp(){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
            // Initiate the Webdriver
            driver = new FirefoxDriver();
        }

        @Test
        public void GoogleTitleTest() {
            // adding implicit wait of 15 secs
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            // URL launch
            driver.get("https://www.google.com");

            // get browser title after browser launch
            System.out.println("Browser title: " + driver.getTitle());

            Assert.assertEquals(driver.getTitle(), "Google");

            driver.quit();

        }

        @After
        public void tearDown(){
          driver.quit();
        }
}
