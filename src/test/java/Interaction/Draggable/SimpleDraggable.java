package Interaction.Draggable;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SimpleDraggable {
    private WebDriver driver;

    @Test
    public void testSimpleDrag() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");
        driver.manage().window().maximize();

        // Локаторы элементов
        WebElement draggableElement = driver.findElement(By.id("draggables"));

        // Получаем начальное положение элемента
        Point initialPosition = draggableElement.getLocation();

        // Перетаскиваем элемент в произвольную точку
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggableElement, 100, 50).perform();

        // Получаем новое положение элемента
        Point newPosition = draggableElement.getLocation();

        // Проверяем, что элемент был перемещен
        assertNotEquals(initialPosition.x, newPosition.x, "Элемент не был перемещен по оси X");
        assertNotEquals(initialPosition.y, newPosition.y, "Элемент не был перемещен по оси Y");

        // Еще раз перетаскиваем
        actions.dragAndDropBy(draggableElement, 200, 80).perform();

        // Получаем новое положение элемента
        Point newPosition2 = draggableElement.getLocation();

        // Проверяем, что элемент был перемещен
        assertNotEquals(initialPosition.x, newPosition2.x, "Элемент не был перемещен по оси X");
        assertNotEquals(initialPosition.y, newPosition2.y, "Элемент не был перемещен по оси Y");

        //driver.quit();
    }
}