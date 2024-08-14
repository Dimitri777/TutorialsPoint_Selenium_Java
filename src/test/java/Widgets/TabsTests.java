package Widgets;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TabsTests {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/tabs.php");
        driver.manage().window().maximize();
    }

    @Test
    public void testTabs() {
            WebElement homeTab = driver.findElement(By.id("nav-home-tab"));
            WebElement profileTab = driver.findElement(By.id("nav-profile-tab"));
            WebElement contactTab = driver.findElement(By.id("nav-contact-tab"));

            // Проверка вкладки "Home"
            homeTab.click();
            WebElement homeContent = driver.findElement(By.id("nav-home"));
            String homeText = homeContent.getText();
            assertTrue(homeText.startsWith("Lorem Ipsum has been the industry's"));

            // Проверка вкладки "Profile"
            profileTab.click();
            WebElement profileContent = driver.findElement(By.id("nav-profile"));
            String profileText = profileContent.getText();
            assertTrue(profileText.startsWith("It is a long established fact that a reader"));

            // Проверка вкладки "Contact"
            contactTab.click();
            WebElement contactContent = driver.findElement(By.id("nav-contact"));
            String contactText = contactContent.getText();
            assertTrue(contactText.startsWith("There are many variations of passages of Lorem Ipsum"));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
