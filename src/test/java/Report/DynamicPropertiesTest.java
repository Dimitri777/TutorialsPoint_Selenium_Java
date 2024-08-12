package Report;

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
import static org.junit.Assert.assertEquals;

public class DynamicPropertiesTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");

        // Инициализация браузера
        driver = new FirefoxDriver();

        // Открытие веб-страницы
        driver.get("https://www.tutorialspoint.com/selenium/practice/dynamic-prop.php");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testButtonVisibilityAfterDelay() {

        WebElement colorChangeButton = driver.findElement(By.xpath("//button[@id='colorChange']"));
        colorChangeButton.click();

        // Получаем текущее время перед ожиданием появления кнопки
        long startTime = System.currentTimeMillis();

        // Ожидаем, пока кнопка "Visible After 5 Seconds" станет видимой
        WebElement visibleAfter5SecondsButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']"))
        );

        // Получаем текущее время после появления кнопки
        long endTime = System.currentTimeMillis();

        // Рассчитываем разницу во времени в миллисекундах
        long timeTaken = endTime - startTime;

        // Проверяем, что кнопка действительно видима
        assertTrue(visibleAfter5SecondsButton.isDisplayed());

        // Проверяем, что кнопка появилась через 5000 миллисекунд (5 секунд) с допустимой погрешностью
        assertTrue("Кнопка появилась не через 5 секунд", timeTaken >= 4000 && timeTaken < 6000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
