package Interaction.Droppable;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.junit.Test;

public class SimpleDroppableTest {
    private WebDriver driver;

    @Test
    public void testSimpleDroppable() {
        // Запускаем браузер и открываем страницу
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrx\\Documents\\Drivers\\firefox\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        driver.manage().window().maximize();

        // Локаторы элементов
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableArea = driver.findElement(By.id("droppable"));

        // Перетаскиваем элемент в целевую область
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableArea).perform();

        // Проверка, что элемент был перетащен (например, проверка его нового положения)
        // ... (Здесь может потребоваться более конкретная проверка в зависимости от реализации)
        Assert.assertTrue(droppableArea.getText().contains("Dropped"));

        driver.quit();
    }
}