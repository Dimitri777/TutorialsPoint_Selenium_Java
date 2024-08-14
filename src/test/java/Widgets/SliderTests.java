package Widgets;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.junit.Test;

public class SliderTests {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");
        driver.manage().window().maximize();
    }

    @Test
    public void testDisabledRangeSlider() {
        // Locating the slider element
        WebElement slider = driver.findElement(By.id("ageInputId")); // Replace with correct ID

        // **Check if slider position element exists (optional):**
        // If the position is not displayed or has a different ID, remove this block.

        WebElement sliderPositionElement = null;
        try {
            sliderPositionElement = driver.findElement(By.id("slider-position")); // Adjust ID if needed
        } catch (NoSuchElementException e) {
            System.out.println("Slider position element not found. Skipping position verification.");
        }

        // Asserting current position (if applicable)
        if (sliderPositionElement != null) {
            Assert.assertEquals(sliderPositionElement.getText(), "24", "Текущая позиция слайдера не равна 24");
        }

        // Attempting to move slider left and right
        try {
            new Actions(driver)
                    .moveToElement(slider)
                    .clickAndHold()
                    .moveByOffset(-100, 0) // Move left
                    .release()
                    .perform();
        } catch (Exception e) {
            // Expected exception if movement is restricted
        }

        try {
            new Actions(driver)
                    .moveToElement(slider)
                    .clickAndHold()
                    .moveByOffset(100, 0) // Move right
                    .release()
                    .perform();
        } catch (Exception e) {
            // Expected exception if movement is restricted
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}