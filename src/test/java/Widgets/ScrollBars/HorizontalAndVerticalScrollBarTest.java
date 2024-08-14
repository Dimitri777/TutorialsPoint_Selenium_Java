package Widgets.ScrollBars;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HorizontalAndVerticalScrollBarTest {
        WebDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://www.tutorialspoint.com/selenium/practice/horizontal-scroll.php");
            driver.manage().window().maximize();

    }

    @Test
    public void testVerticalScroll() {

        // Находим элемент с внутренним вертикальным скроллбаром
        By scrollableElementLocator = By.xpath("//div[@class='horizan-scroll']");

        // Ожидаем, пока элемент станет видимым и кликабельным
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scrollableElement = wait.until(ExpectedConditions.elementToBeClickable(scrollableElementLocator));

        // Прокручиваем до конца вниз
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableElement);
        } catch (WebDriverException e) {
            System.out.println("Ошибка при прокрутке вниз: " + e.getMessage());
            // ... (обработка ошибки)
        }

        // Прокручиваем до начала

        try {
            js.executeScript("arguments[0].scrollTop = 0;", scrollableElement);
        } catch (WebDriverException e) {
            System.out.println("Ошибка при прокрутке вверх: " + e.getMessage());
            // ... (обработка ошибки)
        }

    }

    @Test
    public void testHorizontalScroll() {
        // Находим элемент с внутренним скроллбаром (замените на ваш селектор)
        By scrollableElementLocator = By.xpath("//div[@class='horizan-scroll']");

        // Ожидаем, пока элемент станет видимым и кликабельным
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scrollableElement = wait.until(ExpectedConditions.elementToBeClickable(scrollableElementLocator));

        // Прокручиваем до конца вправо
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableElement);
        } catch (WebDriverException e) {
            System.out.println("Ошибка при прокрутке: " + e.getMessage());
            // Дополнительная логика обработки ошибки (например, скриншот, логгирование)
        }

        // Прокручиваем до начала
        try {
            js.executeScript("arguments[0].scrollLeft = 0;", scrollableElement);
        } catch (WebDriverException e) {
            // ... (обработка ошибки)
        }

    }

        @After
        public void tearDown(){
            driver.quit();
        }
}
